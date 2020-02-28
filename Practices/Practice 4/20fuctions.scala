import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/git/BigData/Spark_DataFrame/Sales.csv")

df.printSchema()

///////////////////////
/// Two way to make filters 1 with scala and 2 with sparksql
///////////////////////

import spark.implicits._

// [ 1 ]
df.select(approx_count_distinct("Company": String)).show()    

// [ 2 ]
df.select(avg("Sales")).show()

// [ 3 ]
df.select(collect_list("Person")).show()

// [ 4 ]
df.select(collect_set("Company")).show()

// [ 5 ]
df.select(corr("Sales","Sales")).show()

// [ 6 ]
df.select(count("Person")).show()

// [ 7 ]
df.select(countDistinct("Company")).show()

// [ 8 ]
df.select(covar_pop("Sales","Sales")).show()

// [ 9 ]
df.select(covar_samp("Sales","Sales")).show()

// [ 10 ]
df.select(first("Person")).show()

// [ 11 ]
df.select(kurtosis("Sales")).show()

// [ 12 ]
df.select(last("Person")).show()

// [ 13 ]
df.select(max("Sales")).show()

// [ 14 ]
df.select(mean("Sales")).show()

// [ 15 ]
df.select(min("Sales")).show()

// [ 16 ]
df.select(skewness("Sales")).show()

// [ 17 ]
df.select(stddev("Sales")).show()

// [ 18 ]
df.select(stddev_pop("Sales")).show()

// [ 19 ]
df.select(stddev_samp("Sales")).show()

// [ 20 ]
df.select(stddev_samp("Sales")).show()