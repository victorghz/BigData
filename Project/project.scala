import org.apache.spark.ml.classification.LogisticRegression

import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()
//----------------------------------------------------CARGA DE DATOS----------------------------------------------------
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("bank-full.csv")

//----------------------------------------------------TRANSFORMACION DE DATOS-------------------------------------------
val c1 = data.withColumn("Target",when(col("Target").equalTo("yes"),1).otherwise(col("Target")))
val c2 = c1.withColumn("Target",when(col("Target").equalTo("no"),0).otherwise(col("Target")))
val c3= c2.withColumn("Target",'Target.cast("Int"))

val c4 = c3.withColumn("marital",when(col("marital").equalTo("single"),1).otherwise(col("marital")))
val c5 = c4.withColumn("marital",when(col("marital").equalTo("married"),2).otherwise(col("marital")))
val c6 = c5.withColumn("marital",when(col("marital").equalTo("divorced"),3).otherwise(col("marital")))
val c7 = c6.withColumn("marital",'marital.cast("Int"))

val df = c7.withColumnRenamed("Target", "label")

val data_clean = df.na.drop()

val assembler = new VectorAssembler().setInputCols(Array("age","marital","balance")).setOutputCol("features")
val Array(training, test) = data_clean.randomSplit(Array(0.7, 0.3), seed = 12345)

//----------------------------------------------------LOGISTIC REGRESSION-----------------------------------------------
val lr = new LogisticRegression()
val lr_pipeline = new Pipeline().setStages(Array(assembler,lr))
val model = lr_pipeline.fit(training)
val predictions_lr = model.transform(test)

import org.apache.spark.mllib.evaluation.MulticlassMetrics
val predictionAndLabels = predictions_lr.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

val lr_accuracy = metrics.accuracy

//----------------------------------------------------MULTI LAYER PERCEPTRON--------------------------------------------

val perceptron_data = assembler.transform(data_clean)

val splits = perceptron_data.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = splits(0)
val test_data = splits(1)

val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(perceptron_data)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(perceptron_data)

val layers = Array[Int](3, 5, 4, 2)

val trainer = new MultilayerPerceptronClassifier()
.setLayers(layers)
.setLabelCol("indexedLabel")
.setFeaturesCol("indexedFeatures")
.setBlockSize(128)
.setSeed(1234L)
.setMaxIter(100)

import org.apache.spark.ml.feature.IndexToString

val labelConverter = new IndexToString()
.setInputCol("prediction")
.setOutputCol("predictedLabel")
.setLabels(labelIndexer.labels)

val perceptron_pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, trainer, labelConverter))

val model = perceptron_pipeline.fit(train)

val predictions_perceptron = model.transform(test_data)

val evaluator = new MulticlassClassificationEvaluator()
.setLabelCol("indexedLabel")
.setPredictionCol("prediction")
.setMetricName("accuracy")
val perceptron_accuracy = evaluator.evaluate(predictions_perceptron)

//----------------------------------------------------DECISION TREE CLASSIFIER--------------------------------------------
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier

val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

val labelConverter = new IndexToString()
.setInputCol("prediction")
.setOutputCol("predictedLabel")
.setLabels(labelIndexer.labels)

val dt_pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))

val model = dt_pipeline.fit(train)

val predictions_tree = model.transform(test_data)

val dt_accuracy = evaluator.evaluate(predictions_tree)

//----------------------------------------------------SVM--------------------------------------------
val featureCols= Array("age","marital","balance")
val assembler = new VectorAssembler().setInputCols(featureCols).setOutputCol("features")
val d=assembler.transform(data_clean)
val dataf=d.select("label","features")
import org.apache.spark.ml.classification.LinearSVC
val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)
val lsvcModel=lsvc.fit(dataf)
val predictions_lsvc = lsvcModel.transform(dataf)

val lsvm_predictionAndLabels = predictions_lsvc.select($"prediction",$"label").as[(Double, Double)].rdd
val lsvm_metrics = new MulticlassMetrics(lsvm_predictionAndLabels)

val lsvm_accuracy = lsvm_metrics.accuracy

//                      PREDICTIONS TABULAR
//Logistic Regression
predictions_lr.select($"label",$"features",$"prediction").show()
//Multilayer Perceptron
predictions_perceptron.select($"label",$"features",$"prediction").show()
//Decision Tree
predictions_tree.select($"label",$"features",$"prediction").show()
//SVM Results
predictions_lsvc.select($"label",$"features",$"prediction").show()
//      PREDICTIONS TABULAR WHEN THE PREDICTION VALUE IS 1.0
//Logistic Regression
predictions_lr.select($"label",$"features",$"prediction").filter($"prediction" > 0).show()
//Multilayer Perceptron
predictions_perceptron.select($"label",$"features",$"prediction").filter($"prediction" > 0).show()
//Decision Tree
predictions_tree.select($"label",$"features",$"prediction").filter($"prediction" > 0).show()
//SVM Results
predictions_lsvc.select($"label",$"features",$"prediction").filter($"prediction" > 0).show()
//                      ACCURACY VALUES
println("Linear Regression Accuracy ->  " +lr_accuracy)
println("Multilayer Perceptron Accuracy ->  " +perceptron_accuracy)
println("Decision Tree ->  " +dt_accuracy)
println("SVM Results Accuracy ->  " +lsvm_accuracy)

