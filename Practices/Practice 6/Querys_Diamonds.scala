import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/P2-Mispriced-Diamonds.csv")

df.printSchema()


import spark.implicits._


df.show()

//scala notation
df.filter($"price">350).show()

//sparksql notation
df.filter("price> 480").show()

df.filter($"price" < 340 && $"carat" < 0.30).show()

df.filter("price < 340 AND carat < 0.30").show()

//Collect the results
val result = df.filter($"price" < 340 && $"carat" < 0.30).collect()

//Count the results
val result = df.filter($"[price" < 340 && $"carat" < 0.30).count()

//equality
df.filter($"clarity"==="SI1").show()
df.groupBy("clarity").count().show()

df.select(countDistinct("clarity")).show()
df.select(avg("carat")).show()
df.select(avg("price")).show()
df.orderBy("clarity").show()


