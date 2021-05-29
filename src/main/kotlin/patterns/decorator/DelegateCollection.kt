package patterns.decorator

class DelegateCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override fun contains(element: T): Boolean = innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()

    override val size: Int get() = innerList.size
}