class IndeterminateException(override val message: String = ""): Exception(message)
class UnsolvableException(override val message: String = ""): Exception(message)

class LinEq(val a: Double, val b: Double, val c: Double)

class LinearEquationSolver{
    fun solveX(eq1: LinEq, eq2: LinEq): Double{
            if(eq1.a*eq2.b-eq1.b*eq2.a == 0.0 && eq1.c*eq2.b-eq1.b*eq2.c == 0.0 && eq1.a*eq2.c-eq1.c*eq2.a == 0.0) throw IndeterminateException("Indeterminate system, infinite number of solutions.")
            if(eq1.a*eq2.b-eq1.b*eq2.a == 0.0 && (eq1.c*eq2.b-eq1.b*eq2.c != 0.0 || eq1.a*eq2.c-eq1.c*eq2.a != 0.0)) throw UnsolvableException("Unsolvable system, there is no solution")
            return (eq1.c*eq2.b-eq1.b*eq2.c)/(eq1.a*eq2.b-eq1.b*eq2.a)
    }
    fun solveY(eq1: LinEq, eq2: LinEq): Double{
            if(eq1.a*eq2.b-eq1.b*eq2.a == 0.0 && eq1.c*eq2.b-eq1.b*eq2.c == 0.0 && eq1.a*eq2.c-eq1.c*eq2.a == 0.0) throw IndeterminateException("Indeterminate system, infinite number of solutions.")
            if(eq1.a*eq2.b-eq1.b*eq2.a == 0.0 && (eq1.c*eq2.b-eq1.b*eq2.c != 0.0 || eq1.a*eq2.c-eq1.c*eq2.a != 0.0)) throw UnsolvableException("Unsolvable system, there is no solution")
            return (eq1.a*eq2.c-eq1.c*eq2.a)/(eq1.a*eq2.b-eq1.b*eq2.a)
    }
}

fun main(args: Array<String>) {

    val equationRegex = """\d{1,10}x\+\d{1,10}y=\d{1,10}""".toRegex()
    val a = """\d{1,10}x""".toRegex()
    val b = """\d{1,10}y""".toRegex()
    val c = """=\d{1,10}""".toRegex()

    println("Please enter first equation:")
    var input = readLine().toString()
    while(!equationRegex.matches(input = input)){
        println("This is not a valid equation. Please use this pattern: #x+#y=#")
        input = readLine().toString()
    }
    println("Equation accepted.\nPlease enter second equation:")
    val eq1 = LinEq(a.find(input = input)?.value?.trim('x')?.toDouble()!!, b.find(input = input)?.value?.trim('y')?.toDouble()!!, c.find(input = input)?.value?.trim('=')?.toDouble()!!)

    input = readLine().toString()
    while(!equationRegex.matches(input = input)){
        println("This is not a valid equation. Please use this pattern: #x+#y=#")
        input = readLine().toString()
    }
    println("Equation accepted.")
    val eq2 = LinEq(a.find(input = input)?.value?.trim('x')?.toDouble()!!, b.find(input = input)?.value?.trim('y')?.toDouble()!!, c.find(input = input)?.value?.trim('=')?.toDouble()!!)

    val linEqSol = LinearEquationSolver()

    try {
        println("Solution:\nx = ${linEqSol.solveX(eq1, eq2)}\ny = ${linEqSol.solveY(eq1, eq2)}")
    }
    catch (e: IndeterminateException){
        println(e.message)
    }
    catch (e: UnsolvableException){
        println(e.message)
    }
}