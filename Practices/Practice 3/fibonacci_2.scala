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