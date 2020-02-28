import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008.csv")
import spark.implicits._

df.printSchema()

// [ 1 ]
df.select(approx_count_distinct("Date": String)).show()    

// [ 2 ]
df.select(avg("Volume")).show()

// [ 3 ]
df.select(collect_list("Date")).show()

// [ 4 ]
df.select(collect_set("Open")).show()

// [ 5 ]
df.select(corr("Open","Volume")).show()

// [ 6 ]
df.select(count("Volume")).show()

// [ 7 ]
df.select(countDistinct("Date")).show()

// [ 8 ]
df.select(covar_pop("High","Low")).show()

// [ 9 ]
df.select(covar_samp("High","Low")).show()

// [ 10 ]
df.select(first("Date")).show()

// [ 11 ]
df.select(kurtosis("Low")).show()

// [ 12 ]
df.select(last("Date")).show()

// [ 13 ]
df.select(max("Date")).show()

// [ 14 ]
df.select(mean("Date")).show()

// [ 15 ]
df.select(min("Date")).show()

// [ 16 ]
df.select(skewness("Date")).show()

// [ 17 ]
df.select(stddev("Close")).show()

// [ 18 ]
df.select(stddev_pop("Volume")).show()

// [ 19 ]
df.select(stddev_samp("Volume")).show()

// [ 20 ]
df.select(stddev_samp("Volume")).show()