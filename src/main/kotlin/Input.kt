import java.io.File

class Input(day: String) {
    private val file = File("src/main/kotlin/day_$day/input.txt")

    fun getStrings(): List<String> = file.readLines()

    fun getInts(): List<Int> = file.readLines().map { it.toInt() }

    fun getSplitStrings(vararg delimiters: Char): List<String> = file.readText().split(*delimiters)

    fun getSplitInts(vararg delimiters: Char): List<Int> = file.readText().split(*delimiters).map { it.toInt() }
}