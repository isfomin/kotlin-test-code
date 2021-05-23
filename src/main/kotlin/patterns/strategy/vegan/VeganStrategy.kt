package patterns.strategy.vegan

class VeganStrategy : Strategy {

    override fun eat(eat: Eat) {
        if (eat.type == EatType.MEAT) {
            println("I will not eat it (${eat.title})")
        } else {
            println("${eat.title} is eaten")
        }
    }
}