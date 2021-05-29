package patterns.decorator

import core.Executable

class DecoratorSample : Executable {

    override fun execute() {
        val cset = CountingSet<Int>()
        cset.addAll(listOf(1, 1, 2))
        println("${cset.objectsAdded} objects were added, ${cset.size} remain")
    }
}