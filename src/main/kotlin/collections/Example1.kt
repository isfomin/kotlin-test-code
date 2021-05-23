package collections

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

// позиция, с которой удаляем
private var m = 0
// количество удаляемых элементов
private var n = 0
// количество элементов в списке
private const val size = 1000000
// основной список (для удаления вызовом remove() и его копия для удаления путём перезаписи)
private lateinit var initList: ArrayList<Int>
private lateinit var copyList: ArrayList<Int>

fun showExample1() {
    initList = ArrayList(size)
    for (i in 0 until size) {
        initList.add(i)
    }
    println("Список из 1.000.000 элементов заполнен")

    copyList = ArrayList(initList)
    println("Создана копия списка\n")

    val reader = BufferedReader(InputStreamReader(System.`in`))
    try {
        print("С какой позиции удаляем? > ")
        m = reader.readLine().toInt()
        print("Сколько удаляем? > ")
        n = reader.readLine().toInt()
    } catch (e: IOException) {
        error(e)
    }
    println("\nВыполняем удаление вызовом remove()...")
    var start = System.currentTimeMillis()

    for (i in m-1 until m+n-1) {
        initList.remove(i)
    }

    var finish = System.currentTimeMillis() - start
    println("Время удаления с помощью вызова remove(): $finish")
    println("Размер исходного списка после удаления: " + initList.size)

    println("\nВыполняем удаление путём перезаписи...\n")
    start = System.currentTimeMillis()

    removeEfficiently()

    finish = System.currentTimeMillis() - start
    println("Время удаления путём смещения: $finish")
    println("Размер копии списка: ${copyList.size}")

    println("\nВыполняем удаления через SubList...\n")
    start = System.currentTimeMillis()

    initList.subList(m - 1, m + n).clear()

    finish = System.currentTimeMillis() - start
    println("Время удаления через саблист: $finish")
    println("Размер копии списка: ${copyList.size}")
}

private fun removeEfficiently() {
    /**
     * Если необходимо удалить все элементы, начиная с указанного,
     * то удаляем элементы с конца до m
     */
    if (m + n >= size) {
        var i = size - 1
        while (i != m - 1) {
            copyList.remove(i)
            i--
        }
    } else {
        // переменная k необходима для отсчёта сдвига начиная от места вставка m
        for ((k, i) in (m+n until size).withIndex()) {
            copyList[m + k] = copyList[i]
        }

        // удаляем ненужные элементы в конце списка
        // удаляется всегда последний элемент, так как время этого действия
        // фиксированно и не зависит от размера списка
        var i = size - 1
        while (i != size - n - 1) {
            copyList.remove(i)
            i--
        }
        // сокращаем длину списка путём удаления пустых ячеек
        copyList.trimToSize()
    }
}