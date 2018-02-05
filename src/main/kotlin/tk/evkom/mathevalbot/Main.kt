package tk.evkom.mathevalbot

fun main(args: Array<String>) {

    val equationRegex = """\d{1,10}x\+\d{1,10}y=\d{1,10}""".toRegex()
    val a = """[0-9]+x""".toRegex()
    val b = """[0-9]+y""".toRegex()
    val c = """=[0-9]+""".toRegex()

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
        println("Solution:\nx = ${linEqSol.solve(eq1, eq2).first}\ny = ${linEqSol.solve(eq1, eq2).second}")
    }
    catch (e: IndeterminateException){
        println(e.message)
    }
    catch (e: UnsolvableException){
        println(e.message)
    }
}