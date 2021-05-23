package collections

import core.Executable
import java.util.concurrent.CopyOnWriteArrayList

class CollectionSamples : Executable {

    /**
     * Как поведёт себя уже инстанциированный итератор для collection, если вызвать collection.remove()?
     *
     * При следующем вызове методов итератора будет выброшено ConcurrentModificationException.
     */
    private fun callConcurrentModificationException(collection: ArrayList<String>) {
        val iterator = collection.iterator()
        collection.remove("123")
        iterator.next()
    }

    /**
     * Как поведёт себя коллекция, если вызвать iterator.remove()?
     *
     * Если вызову iterator.remove() предшествовал вызов iterator.next(), то iterator.remove()
     * удалит элемент коллекции, на который указывает итератор, в противном случае будет
     * выброшено IllegalStateException().
     */
    private fun callIllegalStateException(collection: ArrayList<String>) {
        val iterator = collection.iterator()
        iterator.remove()
    }

    /**
     * Как избежать ConcurrentModificationException во время перебора коллекции?
     * Как вариант использовать ConcurrentHashMap и CopyOnWriteArrayList.
     */
    private fun failSafeIterator(collection: ArrayList<String>) {
        val list = CopyOnWriteArrayList(collection)
        val iterator = list.iterator()
        list.remove("123")
        iterator.next()
    }

    override fun execute() {
        val collection = arrayListOf("123", "324", "234")
        //callConcurrentModificationException(collection)
        //callIllegalStateException(collection)
        //failSafeIterator(collection)

        showExample1()
    }
}