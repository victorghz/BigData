import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/git/BigData/Spark_DataFrame/Sales.csv")

df.printSchema()

///////////////////////
/// Two way to make filters 1 with scala and 2 with sparksql
///////////////////////

import spark.implicits._

// [ 1 ] Returns the approximate number of distinct items in a group.
df.select(approx_count_distinct("Company": String)).show()    

// [ 2 ] Returns the average of the values in a group.
df.select(avg("Sales")).show()

// [ 3 ] Returns a list of objects with duplicates.
df.select(collect_list("Person")).show()

// [ 4 ] Returns a set of objects with duplicate elements eliminated.
df.select(collect_set("Company")).show()

// [ 5 ] Returns the Pearson Correlation Coefficient for two columns.
df.select(corr("Sales","Sales")).show()

// [ 6 ] Returns the number of items in a group.
df.select(count("Person")).show()

// [ 7 ] Returns the number of distinct items in a group.
df.select(countDistinct("Company")).show()

// [ 8 ] Returns the population covariance for two columns.
df.select(covar_pop("Sales","Sales")).show()

// [ 9 ] Returns the sample covariance for two columns.
df.select(covar_samp("Sales","Sales")).show()

// [ 10 ] Returns the first value of a column in a group.
df.select(first("Person")).show()

// [ 11 ] Returns the kurtosis of the values in a group.
df.select(kurtosis("Sales")).show()

// [ 12 ] Returns the last value of the column in a group.
df.select(last("Person")).show()

// [ 13 ] Returns the maximum value of the column in a group.
df.select(max("Sales")).show()

// [ 14 ] Returns the average of the values in a group.
df.select(mean("Sales")).show()

// [ 15 ] Returns the minimum value of the column in a group.
df.select(min("Sales")).show()

// [ 16 ] Returns the skewness of the values in a group.
df.select(skewness("Sales")).show()

// [ 17 ] alias for stddev_samp.
df.select(stddev("Sales")).show()

// [ 18 ] Returns the population standard deviation of the expression in a group.
df.select(stddev_pop("Sales")).show()

// [ 19 ] Returns the sample standard deviation of the expression in a group.
df.select(stddev_samp("Sales")).show()

// [ 20 ] Returns the population variance of the values in a group. 
df.select(var_pop("Sales")).show()