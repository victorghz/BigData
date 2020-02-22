import scala.collection.JavaConversions._

object Fibonacci {

  def main(args: Array[String]): Unit = {
    var n1: Int = 0
    var n2: Int = 1
    var aux: Int = 0
    val limite: Int = 1000
    println(n1)
    println(n2)
    while (n2 + n1 <= limite) {
      aux = n1
      n1 = n2
      n2 = aux + n1
      println(n2)
    }
  }

}