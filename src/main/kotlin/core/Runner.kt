package core

class Runner(private val codeParts: List<Executable> = ArrayList()) : IRunner {

    override fun run() {
        for (code in codeParts) {
            code.execute()
        }
    }
}