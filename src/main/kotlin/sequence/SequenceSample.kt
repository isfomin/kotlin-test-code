package sequence

import core.Executable
import java.io.File

class SequenceSample : Executable {

    override fun execute() {
        exampleGenerateSequence()
        exampleSequence()
        exampleSequenceWithFile()
    }

    private fun exampleGenerateSequence() {
        // промежуточная операция
        val naturalNumbers = generateSequence(0) { it + 1 }
        // промежуточная операция
        val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
        // реальные числа в последовательности будут вычислены в момент вызова завершающей операции sum
        println(numbersTo100.sum())
    }

    private fun exampleSequence() {
        val result = listOf(1, 2, 3, 4).asSequence()
            .map { it * it }
            .filter { it > 3 }
            .toList()
        println(result)
    }

    private fun exampleSequenceWithFile() {
        val file = File("C://Users/Default/NTUSER.DAT")
        //val file = File("C://Users/admin/angular-cli.json")
        println(file.isInsideHiddenDirectory())
    }

    /**
     * Проверяет находится ли файл в скрытом каталоге
     */
    private fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }
}