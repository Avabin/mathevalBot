package tk.evkom.mathevalbot

class LinearEquationSolver{
    fun solve(eq1: LinEq, eq2: LinEq): Pair<Double, Double>{
        val d = (eq1.a*eq2.b-eq1.b*eq2.a)
        val dx = (eq1.c*eq2.b-eq1.b*eq2.c)
        val dy = (eq1.a*eq2.c-eq1.c*eq2.a)
        if (d == 0.0 && dx == 0.0 && dy == 0.0) throw IndeterminateException()
        if (d == 0.0 && (dx == 0.0 || dy == 0.0)) throw UnsolvableException()
        return Pair(dx/d, dy/d)
    }
}