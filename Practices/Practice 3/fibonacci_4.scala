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