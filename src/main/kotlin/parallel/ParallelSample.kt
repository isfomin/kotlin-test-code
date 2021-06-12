package parallel

import core.Executable
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class ParallelSample : Executable {

    override fun execute() {
        exampleExecutors()
        exampleCallable()
    }

    private fun exampleExecutors() {
        val service = Executors.newFixedThreadPool(8)
        var i = 0
        val items = createItems()

        while (i < items.size) {
            val item = items[i]
            service.submit {
                processItem(item)
            }
            i++
        }
    }

    private fun exampleCallable() {
        val service = Executors.newFixedThreadPool(3)
        val result = service.submit(Callable {
            return@Callable "Callable result!"
        })

        println(result.get())
    }

    private fun createItems(): List<Int> {
        val naturalNumbers = generateSequence(0) { it + 1 }.takeWhile { it <= 100 }
        return naturalNumbers.toList()
    }

    private fun processItem(item: Int) {
        println(item)
    }
}