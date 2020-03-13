# BigData
<b><p align="center">
                                                 TECNOLÓGICO NACIONAL DE MÉXICO</br>
                                                INSTITUTO TECNOLÓGICO DE TIJUANA</br>
                                                      SUBDIRECCIÓN ACADÉMICA</br>
                                              DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN</br> 
                                                           PERIODO</br>
                                                      Enero - Junio 2020</br>
                                                           CARRERA</br>
                                               Ing. En Sistemas Computacionales</br>
                                                          ASIGNATURA</br> 
                                                Datos Masivos (BDD-1704 IF9A)</br>
                                                           DOCENTE</br>
                                                Jose Christian Romero Hernandez</br>
                                                           EQUIPO</br>
                                             16210958 - Aguirre Ibarra Jesus Armando</br>
                                             14212024 - Garcia Hernandez Victor David</br>                                                                                     
</p></b>

## Unit 1
### Index

[Exam Part 1](#id9)

[Exam Part 2](#id10)

### Exam Part 1<a name="id9"></a>
**Instructions**

Given a square matrix, calculate the absolute difference between the sums of your diagonals. For example, the square matrix is shown below:

```txt
arr = [[11, 2, 4], [4, 5, 6], [10, 8, -12]]
```

diagonal_1 = 11 + 5 - 12 = 4

diagonal_2 = 4 + 5 + 10 = 19

Difference Abosulta = | 4 - 19 | = 15

Descriptive function:

Developing a function called diagonalDifference is a scrip with the Scala programming language. It must return an integer that represents the difference of the absolute diagonal.

diagonalDifference takes the following parameter:

arr

**Code**
```scala
def diagonalDifference(arr:Array[Array[Int]]): Int= {    
    var count : Int = 1
    val mutmap = collection.mutable.Map((0, 0))

    for(i <- arr){
        for(x <- i){
            mutmap += (count -> x)
            count = count + 1 
        }
    }

    var Diag1 : Int = 0
    var Diag2 : Int = 0
    
    Diag1 = mutmap(1) + mutmap(5) + mutmap(9)
    Diag2 = mutmap(3) + mutmap(5) + mutmap(7)

    var DiffAbs : Int = (Diag1 - Diag2)

    if(DiffAbs < 0 ){
        DiffAbs = DiffAbs * -1
    }

    return DiffAbs
}

var arr=Array(Array(11,2,4),Array(4,5,6),Array(10,8,-12))


diagonalDifference(arr)
```
### Exam Part 2  <a name="id10"></a> 
**Instruction**

Answer the following questions with Spark DataFrames using the "CSV" Netflix_2011_2016.csv

**Code**
```scala
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
df.describe().show()for(i <- Array.range(0,5))
    {
        println(df.columns(i))
    }
    
/* [ 7 ] Create a new dataframe with a column called new called "HV Ratio" which is the 
relationship between the price of the "High" column versus the "Volume" column of shares 
traded for a day */
val dfHVRatio = df.withColumn("HV Ratio",df("High")/df("Volume")) 

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
```
