package core

class Runner(private val modules: Modules) : IRunner {

    override fun run() {
        val codeParts = modules.map
        for (entry in codeParts.entries) {
            if (entry.value) {
                println("/* ${entry.key.javaClass} start */")
                entry.key.execute()
                println("/* ${entry.key.javaClass} end */\n")
            }
        }
    }
}