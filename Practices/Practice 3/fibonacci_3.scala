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