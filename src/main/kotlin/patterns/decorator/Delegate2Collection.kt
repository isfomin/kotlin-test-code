package patterns.decorator

/**
 * Делегирование класса
 */
class Delegate2Collection<T>(
    innerList: Collection<T> = ArrayList()
) : Collection<T> by innerList { }