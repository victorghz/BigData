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