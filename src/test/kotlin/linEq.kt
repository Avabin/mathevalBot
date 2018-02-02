fun solveLinSet(a1: Double, b1: Double, c1: Double, a2: Double, b2: Double, c2: Double): String{
    val D = a1*b2-a2*b1     //Determinants
    val Dx = c1*b2-c2*b1
    val Dy = a1*c2-a2*c1

    val x = Dx/D    //Cramer's Rule
    val y = Dy/D

    if(D == 0.0){
        if(D == 0.0 && Dx == 0.0 && Dy == 0.0){
            return("Indeterminate system, infinite number of solutions.")
        }
        else{
            return("Unsolvable.")
        }
    }
    else {
        return ("Solution:\nx = ${x}\ny = ${y}")
    }
}

fun main(args: Array<String>) {

    //Solving simple linear equation system with 2 unknown variables

    println("Please specify equation according to this format:\nax + bx = c\nEquation 1")

    print("a: ")
    val a1 = readLine()!!.toDouble()
    print("b: ")
    val b1 = readLine()!!.toDouble()
    print("c: ")
    val c1 = readLine()!!.toDouble()

    println("Equation 2")

    print("a: ")
    val a2 = readLine()!!.toDouble()
    print("b: ")
    val b2 = readLine()!!.toDouble()
    print("c: ")
    val c2 = readLine()!!.toDouble()

    println("Attempting to solve following system:\n${a1}x + ${b1}y = $c1\n${a2}x + ${b2}y = $c2")
    println(solveLinSet(a1, b1, c1, a2, b2, c2))
}