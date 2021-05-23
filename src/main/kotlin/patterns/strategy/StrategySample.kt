package patterns.strategy

import core.Executable
import patterns.strategy.vegan.*

class StrategySample : Executable {

    override fun execute() {
        val apple = Eat("apple", EatType.PLANT)
        val mango = Eat("mango", EatType.PLANT)
        val mutton = Eat("mutton", EatType.MEAT)
        val chicken = Eat("chicken", EatType.MEAT)

        // устанавливаем стратегию мясоед (всеяден)
        println("strategy is meat")
        val member = Member(MeatStrategy());
        // кормим человека
        member.eat(apple)
        member.eat(chicken)
        member.eat(mutton)
        member.eat(mango)

        println()
        println("strategy is vegan")

        // меняем стратегию на вегетарианец
        member.strategy = VeganStrategy()
        // кормим вегетарианца
        member.eat(apple)
        member.eat(chicken)
        member.eat(mutton)
        member.eat(mango)
    }
}