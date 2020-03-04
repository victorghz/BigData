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