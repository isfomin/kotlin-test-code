package patterns.strategy.vegan

class MeatStrategy : Strategy {

    override fun eat(eat: Eat) {
        println("${eat.title} is eaten")
    }
}