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