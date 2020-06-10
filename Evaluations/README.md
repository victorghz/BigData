# BigData
<b><p align="center">
                                                 TECNOLÓGICO NACIONAL DE MÉXICO</br>
                                                INSTITUTO TECNOLÓGICO DE TIJUANA</br>
                                                      SUBDIRECCIÓN ACADÉMICA</br>
                                              DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN</br> 
                                                           PERIODO</br>
                                                      Enero - Junio 2020</br>
                                                           CARRERA</br>
                                               Ing. En Sistemas Computacionales</br>
                                                          ASIGNATURA</br> 
                                                Datos Masivos (BDD-1704 IF9A)</br>
                                                           DOCENTE</br>
                                                Jose Christian Romero Hernandez</br>
                                                           EQUIPO</br>
                                             16210958 - Aguirre Ibarra Jesus Armando</br>
                                             14212024 - Garcia Hernandez Victor David</br>                                                                                     
</p></b>

## Exam Unit 3

**Instructions**
Develop the following instructions in Spark with the Scala programming language.

**Objective:**
The objective of this practical exam is to try to group customers from specific regions of a wholesale distributor. This is based on the sales of some product categories.

The data sources are located in the repository:
https://github.com/jcromerohdz/BigData/blob/master/Spark_clustering/Wholesale%20customers%20data.csv

1. Import a simple Spark session.
2. Use the lines of code to minimize errors
3. Create an instance of the Spark session
4. Import the Kmeans library for the grouping algorithm.
5. Load the Wholesale Customers Data dataset
6. Select the following columns: Fres, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data
7. Import Vector Assembler and Vector.
8. Create a new Vector Assembler object for feature columns as an input set, remembering that there are no labels.
9. Use the assembler object to transform feature_data
10. Create a Kmeans model with K = 3
11. Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.

**Assessment instructions**
- Delivery time 4 days.
- At the end put the code and the explanation in the corresponding branch of your github as well as make your explanation of the solution in your google drive.
- Finally defend its development in a video of 8-10 min which will serve to give its rating, this video must be uploaded to YouTube to be shared by a link.


**Code**
```R
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
```
