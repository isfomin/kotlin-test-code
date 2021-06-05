package core

class Modules {
    val map = HashMap<Executable, Boolean>()

    fun add(executable: Executable, enabled: Boolean = true) {
        map[executable] = enabled
    }
}