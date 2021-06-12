import collections.CollectionSamples
import com.sun.org.apache.xpath.internal.operations.Mod
import core.*
import expressions.ExprSample
import parallel.ParallelSample
import patterns.decorator.DecoratorSample
import patterns.strategy.StrategySample
import sequence.SequenceSample

fun main() {
    val modules = Modules()
    modules.add(CollectionSamples(), false)
    modules.add(StrategySample(), false)
    modules.add(DecoratorSample(), false)
    modules.add(SequenceSample(), false)
    modules.add(ParallelSample(), false)
    modules.add(ExprSample(), true)

    val runner = Runner(modules)
    runner.run()
}