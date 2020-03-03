import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008.csv")
import spark.implicits._

df.printSchema()

// [ 1 ] Returns the approximate number of distinct items in a group.
df.select(approx_count_distinct("Date": String)).show()    

// [ 2 ] Returns the average of the values in a group.
df.select(avg("Volume")).show()

// [ 3 ] Returns a list of objects with duplicates.
df.select(collect_list("Date")).show()

// [ 4 ] Returns a set of objects with duplicate elements eliminated.
df.select(collect_set("Open")).show()

// [ 5 ] Returns the Pearson Correlation Coefficient for two columns.
df.select(corr("Open","Volume")).show()

// [ 6 ] Returns the number of items in a group.
df.select(count("Volume")).show()

// [ 7 ] Returns the number of distinct items in a group.
df.select(countDistinct("Date")).show()

// [ 8 ] Returns the population covariance for two columns.
df.select(covar_pop("High","Low")).show()

// [ 9 ] Returns the sample covariance for two columns.
df.select(covar_samp("High","Low")).show()

// [ 10 ] Returns the first value of a column in a group.
df.select(first("Date")).show()

// [ 11 ] Returns the kurtosis of the values in a group.
df.select(kurtosis("Low")).show()

// [ 12 ] Returns the last value of the column in a group.
df.select(last("Date")).show()

// [ 13 ] Returns the maximum value of the column in a group.
df.select(max("Date")).show()

// [ 14 ] Returns the average of the values in a group.
df.select(mean("Date")).show()

// [ 15 ] Returns the minimum value of the column in a group.
df.select(min("Date")).show()

// [ 16 ] Returns the skewness of the values in a group.
df.select(skewness("Date")).show()

// [ 17 ] alias for stddev_samp.
df.select(stddev("Close")).show()

// [ 18 ] Returns the population standard deviation of the expression in a group.
df.select(stddev_pop("Volume")).show()

// [ 19 ] Returns the sample standard deviation of the expression in a group.
df.select(stddev_samp("Volume")).show()

// [ 20 ] Returns the population variance of the values in a group. 
df.select(var_pop("Volume")).show()