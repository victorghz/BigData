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