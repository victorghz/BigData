# BigData
<div style="text-align: center">
 
## NATIONAL TECHNOLOGICAL OF MEXICO
 
 
## TIJUANA TECHNOLOGICAL INSTITUTE


## ACADEMIC SUB-DIRECTION


## DEPARTMENT OF SYSTEMS AND COMPUTATION


## PERIOD: January - June 2020


## Career: Engineer in Computer Systems


## Subject matter: Massive Data (BDD-1704 IF9A)


## Teacher: Jose Christian Romero Hernandez


## EQUIPMENT:
16210958 - Aguirre Ibarra Jesus Armando
 XXXXXXXX - Victor

</div>


## Unit 1
### Index
[Practice 1](#id1)



### Practice 1 <a name="id1"></a>
**Instructions**
```
1. Develop an algorithm in scala that calculates the radius of a circle
2. Develop an algorithm in scala that tells me if a number is a cousin.
3. Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet".
4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the "Luke" sequence.
5. What is the difference in value and a variable in scala?
6. Given the tuple ((2,4,5), (1,2,3), (3,116,23))) return the number 3.1416
```
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


// 3. Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet".
val bird = "tweet"
val interpolar = "I am writing a "+ bird


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

