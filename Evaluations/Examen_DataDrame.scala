import org.apache.spark.sql.SparkSession

// [ 1 ]
val spark = SparkSession.builder().getOrCreate()

// [ 2 ]
val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/git/BigData/Spark_DataFrame/Netflix_2011_2016.csv") //Finantial Crisis

//[ 3 ]
df.columns

// [ 4 ]
df.printSchema()

// [ 5 ]
df.select("Date","Open","High","Low","Close").show()

// [ 6 ]
df.describe().show()

// [ 7 ] PENDIENTE
val df2 = df.withColumn("HV Ratio", df("High")+df("Volume"))

// [ 8 ] PENDIENTE
val df2 = df.withColumn("Date2", df("Date"))

df2.select($"Date2", $"max(Close)").show()

df.select(max("Close")).show()


// [ 9 ]

