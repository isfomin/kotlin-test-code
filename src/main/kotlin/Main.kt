import collections.CollectionSamples
import core.Executable
import core.Runner
import patterns.strategy.StrategySample

fun main() {
    val modules = ArrayList<Executable>()
    //modules.add(CollectionSamples())
    modules.add(StrategySample())

    val runner = Runner(modules)
    runner.run()
}