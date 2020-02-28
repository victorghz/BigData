//El Coeficiente de Correlación de Pearson es una medida de la correspondencia o relación lineal entre dos variables cuantitativas 
//aleatorias. En palabras más simples se puede definir como un índice utilizado para medir el grado de relación 
//que tienen dos variables, ambas cuantitativas.

//Cuando el coeficiente es negativo las variables se correlacionan en un sentido inverso.

//Cuando el coeficiente es negativo las variables se correlacionan en un sentido directo.

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008.csv")
import spark.implicits._

df.printSchema()

df.select(corr("Open","Volume")).show() //r = -0.7004590761697382

//Como el coeficiente es negativo se dice que los atributos se correlacionan en sentido
//inverso con un 70% de precision