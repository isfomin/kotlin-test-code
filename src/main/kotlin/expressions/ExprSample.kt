package expressions

import core.Executable

class ExprSample : Executable {

    override fun execute() {
        println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
    }
}