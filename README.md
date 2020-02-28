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
```
var lista = List("rojo","blanco","negro")
lista = lista.++:(List("verde" ,"amarillo", "azul", "naranja", "perla"))
val arr = Array.range(1,1000,5)
List(1,3,3,4,6,7,3,7).toSet
var Names = collection.mutable.Map( ("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))
print(Names.keys)
Names += ("Miguel" -> 23)
```
### Practice 3 <a name="id3"></a>
**Instructions**
> Write 5 scala funtions (from different algorithms) where, given a 'n' parameter, print it's value on the fibonacci sequence

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
