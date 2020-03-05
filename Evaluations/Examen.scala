def diagonalDifference(arr:Array[Array[Int]]): Int= {    
    var count : Int = 1
    val mutmap = collection.mutable.Map((0, 0))

    for(i <- arr){
        for(x <- i){
            mutmap += (count -> x)
            count = count + 1 
        }
    }

    var Diag1 def diagonalDifference(arr:Array[Array[Int]]): Int= {    
    var count : Int = 1
    val mutmap = collection.mutable.Map((0, 0))

    for(i <- arr){
        for(x <- i){
            mutmap += (count -> x)
            count = count + 1 
        }
    }

    var Diag1 : Int = 0
    var Diag2 : Int = 0
    
    Diag1 = mutmap(1) + mutmap(5) + mutmap(9)
    Diag2 = mutmap(3) + mutmap(5) + mutmap(7)

    var DiffAbs : Int = (Diag1 - Diag2)

    if(DiffAbs < 0 ){
        DiffAbs = DiffAbs * -1
    }

    return DiffAbs
}

var arr=Array(Array(11,2,4),Array(4,5,6),Array(10,8,-12))


diagonalDifference(arr)

: Int = 0
    var Diag2 : Int = 0
    
    Diag1 = mutmap(1) + mutmap(5) + mutmap(9)
    Diag2 = mutmap(3) + mutmap(5) + mutmap(7)

    var DiffAbs : Int = (Diag1 - Diag2)

    if(DiffAbs < 0 ){
        DiffAbs = DiffAbs * -1
    }

    return DiffAbs
}

var arr=Array(Array(11,2,4),Array(4,5,6),Array(10,8,-12))


diagonalDifference(arr)

