// VARIANCE

// Definition
/*
In probability theory and statistics, variance is the expectation of the squared deviation 
of a random variable from its mean. Informally, it measures how far a set of (random) numbers 
are spread out from their average value. Variance has a central role in statistics, where some 
ideas that use it include descriptive statistics, statistical inference, hypothesis testing, 
goodness of fit, and Monte Carlo sampling. Variance is an important tool in the sciences, 
where statistical analysis of data is common.
*/

// Example
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/git/BigData/Spark_DataFrame/Salesparks.csv")
import spark.implicits._

df.printSchema()

df.select(variance("Sales")).show()

df.select(stddev("Sales")).show()

