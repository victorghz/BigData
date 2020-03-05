import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/P2-Mispriced-Diamonds.csv")

df.printSchema()

import spark.implicits._

df.show()

//SPARKSQL NOTATION
for(i <- Array.range(0,5))
    {
        println(df.columns(i))
    }
// Returns the columns with prices greater than 350.
df.filter($"price">350).show()

// Returns the columns with prices greater than 480.
df.filter("price> 480").show()

// Returns the columns with the price less than 340 and the carat less than 0.30
df.filter($"price" < 340 && $"carat" < 0.30).show()

// Returns the columns with the price less than 340 and the carat less than 0.30
df.filter("price < 340 AND carat < 0.30").show()

// Collect the results
val result = df.filter($"price" < 340 && $"carat" < 0.30).collect()

// Count the results
val result = df.filter($"[price" < 340 && $"carat" < 0.30).count()

// Equality
// Returns the column when the clarity is equal to SI1
df.filter($"clarity"==="SI1").show()

// Returns the Clarity number grouped by Clarity.
df.groupBy("clarity").count().show()

// Count the different clarity.
df.select(countDistinct("clarity")).show()

// Calculate the average the carat column.
df.select(avg("carat")).show()

// Calculate the average the price column.
df.select(avg("price")).show()

// Returns all columns order by clarity.
df.orderBy("clarity").show()
