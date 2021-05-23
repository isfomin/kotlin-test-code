package patterns.strategy.vegan

class Member(var strategy: Strategy) {

    fun eat(eat: Eat) {
        strategy.eat(eat)
    }
}