import collections.CollectionSamples
import core.Executable
import core.Modules
import core.Runner
import patterns.decorator.DecoratorSample
import patterns.strategy.StrategySample
import sequence.SequenceSample

fun main() {
    val modules = Modules()
    modules.add(CollectionSamples(), false)
    modules.add(StrategySample(), false)
    modules.add(DecoratorSample(), true)
    modules.add(SequenceSample(), true)

    val runner = Runner(modules)
    runner.run()
}