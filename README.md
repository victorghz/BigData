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
[Practice 1](#id1)

[Practice 2](#id2)

[Practice 3](#id3)

[Practice 4](#id4)

[Practice 5](#id5)

[Practice 6](#id6)

[Practice 7](#id7)

[Practice 8](#id8)

[Exam Part 1](#id9)

[Exam Part 2](#id10)


### Practice 1 <a name="id1"></a>
**Instructions**
>1. Develop an algorithm in scala that calculates the radius of a circle
>2. Develop an algorithm in scala that tells me if a number is a cousin.
>3. Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet".
>4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the "Luke" sequence.
>5. What is the difference in value and a variable in scala?
>6. Given the tuple ((2,4,5), (1,2,3), (3,116,23))) return the number 3.141

**Code**
```scala
// 1. Develop an algorithm in scala that calculates the radius of a circle
val c = 10
val pi = 2*3.1416
val r= c / pi
println("The radius of the circle is: "+r)


// 2. Develop an algorithm in scala that tells me if a number is a cousin.
val number = 3
var count = 0
for(i <- Range(1, number + 1)) {
 if( num % i == 0) {
   count += 1
 }
}
if(count != 2) {
 println("The number is not a cousin.")
} else {
 println("The number is cousin.")
}


// 3. Given the variable bird = "tweet", use string interpolation to print "Estoy escribiendo un tweet".
val bird = "tweet"
val StringInterpolation = s"Estoy escribiendo un ${bird}"

// 4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the "Luke" sequence.
val star = "Hi Luke, I'm your father!"
star.slice(3,7)


// 5 What is the difference in value and a variable in scala?
//val elements are inmutable, which means that can't change their value once they were defined
//var elements are mutables, which means that can change their value anytime during program execution 
val MyValue : Int = 0
var MyVariable : String = "This is a string"
print(MyVariable)
MyVariable = "Modified variable"
print(MyVariable)
MyValue = 1 //Reassignment fail


// 6. Given the tuple ((2,4,5), (1,2,3), (3,116,23))) return the number 3.1416
val myTuple = ((2,4,5),(1,2,3),(3.1416,23))
println("Tuple: " + myTuple)
val myValue = myTuple._3._1
println("The value at the position ._3._1 is: "+ myValue)
```

### Practice 2 <a name="id2"></a>
**Instructions**
 >1. Create a list called "lista" with the elements "rojo", "blanco", "negro"
 >2. Add 5 more items to "lista" "verde", "amarillo", "azul", "naranja", "perla"
 >3. Get the "verde", "amarillo", "azul" items from "lista"
 >4. Create a number array from 1 to 1000 range in 5-in-5 steps
 >5. What are the unique elements of the list List(1,3,3,4,6,7,3,7) use conversion to sets
 >6. Create a mutable map called "Names" that contains the following
     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
 >7.  Print all map keys
 >8.  Add the following value to the map ("Miguel", 23)
 
**Code**
```scala
// 1. Create a list called "list" with the elements "rojo", "blanco", "negro"
var lista = List("rojo","blanco","negro")

// 2. Add 5 more items to "lista" "verde" ,"amarillo", "azul", "naranja", "perla".
lista = lista.++:(List("verde" ,"amarillo", "azul", "naranja", "perla"))

// 3. Bring the elements of "lista" "verde", "amarillo", "azul".
lista.slice(0,3)

// 4. Create a number array in the 1-1000 range in 5-in-5 steps.
val arr = Array.range(1,1000,5)

// 5. What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets
List(1,3,3,4,6,7,3,7).toSet

// 6. Create a mutable map called names that contains the following
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
var Names = collection.mutable.Map( ("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))

// 6 a . Print all map keys.
print(Names.keys)

// 7 b . AAdd the following value to the map("Miguel", 23)
Names += ("Miguel" -> 23)

```
### Practice 3 <a name="id3"></a>
**Instructions**

Write 5 scala funtions (from different algorithms) where, given a 'n' parameter, print it's value on the fibonacci sequence

**Code**
```
def fibonacci(n:Int) : Double = {
    if(n < 2)
    {
        return n
    }
    else
    {
        return fibonacci(n-1) + fibonacci(n-2)
    }
} 

def fibonacci(n:Int) : Double = {
    if(n < 2)
    {
        return n
    }
    else
    {
        val p = (1 + math.sqrt(5)) / 2
        val j = (math.pow(p,n) - math.pow(1-p,n)) / math.sqrt(5)  
        return j
    }
} 

def fibonacci(n:Int) : Double = {
    var a = 0
    var b = 1
    var c = 0
    for(k <- Array.range(0,n))
    {
        c = b+a
        a = b
        b = c
    }
    return a
}

def fibonacci(n:Int) : Double = {
    var a = 0
    var b = 1
    for(k <- Array.range(0,n))
    {
        b = b+a
        a = b-a
    }
    return a
}

def fibonacci(n:Int) : Double = {
    if(n < 2)
    {
        return n
    }
    else
    {
        val arr = Array.range(0,n+1)
        for(k <- Array.range(2,n+1))
        {
            arr(k) = arr(k-1) + arr(k-2)
        }
        return arr(n)
    }
} 
```
### Practice 4 <a name="id4"></a>
**Instructions**

Investigate 20 functions in spark with the Sales.csv data

**Code**
```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/git/BigData/Spark_DataFrame/Sales.csv")

df.printSchema()

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
```
### Practice 5 <a name="id5"></a>
**Instructions**

Investigate 20 functions in spark with the CitiGroup2006_2008.csv data

**Code**
```scala
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
```
### Practice 6 <a name="id6"></a>
**Instructions**

Query with data from P2-Mispriced-Diamonds.csv

**Code**
```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/P2-Mispriced-Diamonds.csv")

df.printSchema()

import spark.implicits._

df.show()

//SPARKSQL NOTATION

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
```
### Practice 7 <a name="id7"></a>
**Instructions**

Investigate the definition of variance and return this function in apache spark.

**Code**
```scala
// VARIANCE

// Definition
/*
In probability theory and statistics, variance is the expectation of the squared deviation 
of a random variable from its mean. Informally, it measures how far a set of (random) numbers 
are spread out from their average value. Variance has a central role in statistics, where some 
ideas that use it include descriptive statistics, statistical inference, hypothesis testing, 
goodness of fit, and Monte Carlo sampling. Variance is an important tool in the sciences, 
where statistical analysis of data is common.
*/

// Example
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/armando/Documentos/git/BigData/Spark_DataFrame/Salesparks.csv")
import spark.implicits._

df.printSchema()

df.select(variance("Sales")).show()

df.select(stddev("Sales")).show()
```
### Practice 8 <a name="id8"></a>
**Instructions**

Research the pearson correlation.

**Code**
```scala
// PEARSON CORRELATION COEFFICIENT

// Definition
/*The Pearson Correlation Coefficient is a measure of the correspondence or linear 
relationship between two random quantitative variables. In simpler words it can be defined as 
an index used to measure the degree of relationship that two variables have, both quantitative.

When the coefficient is negative, the variables are correlated in the opposite direction.

When the coefficient is negative, the variables are correlated in a direct sense.
*/

// Example

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008.csv")
import spark.implicits._

df.printSchema()

df.select(corr("Open","Volume")).show() //r = -0.7004590761697382

/*
As the coefficient is negative, the attributes are said 
to be correlated in the opposite direction with 70% accuracy
*/
```
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
