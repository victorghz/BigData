// [ 1 ] Start a Spark Session
import org.apache.spark.sql.SparkSession

// [ 2 ] Use the following code below to set the Error reporting
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// [ 3 ] Create an instance of the Spark session.
val spark = SparkSession.builder().getOrCreate()

// [ 4 ] Import the Kmeans library for the grouping algorithm.
import org.apache.spark.ml.clustering.KMeans

// [ 5 ] Loads the Wholesale Customers Data dataset
// val dataset = spark.read.format("libsvm").load("Wholesale customers data.csv")
val dataset = spark.read.option("header","true").option("inferSchema","true").csv("Wholesale customers data.csv")

/* [ 6 ] Select the following columns:
Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data */
val feature_data = dataset.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen")


// [ 7 ] Import Vector Assembler and Vector
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

/* [ 8 ] Create a new Vector Assembler object for feature columns as an input set, 
         remembering that there are no labels */
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")

// [ 9 ] Use the assembler object to transform feature_data
val training_data = assembler.transform(feature_data).select("features")


// [ 10 ] Create a Kmeans model with K = 3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(training_data)

// [ 11 ] Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.
val WSSSE = model.computeCost(training_data)
println(s"Within Set Sum of Squared Errors = $WSSSE")

// Shows the result.
println("Cluster Centers: ")
model.clusterCenters.foreach(println)