def fib1 ( n : Int )  : Int = n match  { 
   case  0 | 1  => n
    caso  _  => fib1 ( n- 1  ) + fib1 ( n- 2  ) 
}

#Tail Recursion
def fib3 ( n : Int )  : Int =  {  
  def fib _ tail ( n : Int, a : Int, b : Int ) : Int = n match  { 
    case  0  => a 
     case  _  => fib _ tail ( n- 1 , b, a + b ) 
  } 
  return fib _ tail ( n, 0 ,1)
}
