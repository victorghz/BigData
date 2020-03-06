// [ 1 ] Start a simple Spark session.
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// [ 2 ] Load the Netflix Stock CSV file, make Spark infer the data types.
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

// [ 3 ] What are the names of the columns? 
df.columns

// [ 4 ] How is the scheme?
df.printSchema()

// [ 5 ] Print the first 5 columns.
    for(i <- Array.range(0,5))
    {
        println(df.columns(i))
    }
    
// [ 6 ] Use describe () to learn about the DataFrame.
df.describe().show()

    
/* [ 7 ] Create a new dataframe with a column called new called "HV Ratio" which is the 
relationship between the price of the "High" column versus the "Volume" column of shares 
traded for a day */
val dfHVRatio = df.withColumn("HV Ratio",df("High")/df("Volume")).show()

// [ 8 ] What day had the highest peak in the "Close" column?
val maxClose = df.select(max("Close"),max("Date")).show()

// [ 9 ] What is the meaning of the "Close" column?
//It is the closing value of Netflix shares.

// [ 10 ] What is the maximum and minimum of the "Volume" column?
df.select(max("Volume")).show()
df.select(min("Volume")).show()

// [ 11 ] With Scala / Spark syntax, answer the following:

// [ a ] How many days was the "Close" column less than $ 600?
df.filter($"Close" < 600).count()

// [ b ] What percentage of the time was the "High" column greater than $ 500?
val high500: Double = df.filter($"High">500).count()
(high500/df.count())*100

// [ c ] What is Pearson's correlation between the "High" column and the "Volume" column?
df.select(corr("High", "Volume")).show()

// [ d ] What is the maximum of the "High" column per year?
val dfWithYearColumn = df.withColumn("Year", year(df("Date")))
dfWithYearColumn.groupBy("Year").max().select($"Year",$"max(High)").show()

// [ e ] What is the average "Close" column for each calendar month?
val dfWithMonthColumn = df.withColumn("Month", month(df("Date")))
dfWithMonthColumn.groupBy("Month").avg().select($"Month",$"avg(Close)").show()