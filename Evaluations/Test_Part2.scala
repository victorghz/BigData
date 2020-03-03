//[1]
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
//[2]
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
//[3]
df.columns
//[4]
df.printSchema()
//[5]
    for(i <- Array.range(0,5))
    {
        println(df.columns(i))
    }
//[6]
df.describe().show()
//[7]
val dfHVRatio = df.withColumn("HV Ratio",df("High")/df("Volume"))
//[8]
val maxClose = df.select(max("Close"),max("Date")).show()
//[9]
//Es el valor de cierre de las acciones de Netflix
//[10]
df.select(max("Volume")).show()
df.select(min("Volume")).show()
//[11]
// [a]
df.filter($"Close" < 600).count()
// [b]
val high500: Double = df.filter($"High">500).count()
(high500/df.count())*100
//[c]
df.select(corr("High", "Volume")).show()
//[d]
val dfWithYearColumn = df.withColumn("Year", year(df("Date")))
dfWithYearColumn.groupBy("Year").max().select($"Year",$"max(High)").show()
//[e]
val dfWithMonthColumn = df.withColumn("Month", month(df("Date")))
dfWithMonthColumn.groupBy("Month").avg().select($"Month",$"avg(Close)").show()
