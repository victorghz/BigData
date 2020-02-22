//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
val numero = 3
var cont = 0
for(i <- Range(1, numero + 1)) {
 if( num % i == 0) {
   cont += 1
 }
}
if(cont != 2) {
 println("Numero no primo")
} else {
 println("El numero es primo ")
}