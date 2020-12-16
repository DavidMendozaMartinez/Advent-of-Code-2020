import java.io.File

class Input(day: String) {
    private val file = File("src/main/kotlin/day_$day/input.txt")
    private val text: String = file.readText()
    private val lines: List<String> = file.readLines()

    fun getStrings(block: String.() -> String = { this }): List<String> = lines.map(block)

    fun getInts(): List<Int> = lines.map { it.toInt() }

    fun getLongs(): List<Long> = lines.map { it.toLong() }

    fun getSplitStrings(vararg delimiters: Char): List<String> = text.split(*delimiters)

    fun getSplitInts(vararg delimiters: Char): List<Int> = text.split(*delimiters).map { it.toInt() }

    fun getStringPairs(delimiter: String): List<Pair<String, String>> =
        lines.map { it.substringBefore(delimiter) to it.substringAfter(delimiter) }

    fun getCharMatrix(): List<List<Char>> = lines.map { it.toList() }

    fun getStringGroupList(elementDelimiter: String, stringDelimiter: String): List<List<String>> =
        text.split(elementDelimiter).map { it.split(stringDelimiter) }

    fun getStringMapList(
        elementDelimiter: String,
        vararg pairDelimiter: String,
        stringDelimiter: String
    ): List<Map<String, String>> =
        text.split(elementDelimiter)
            .map { element ->
                element
                    .split(*pairDelimiter)
                    .associateBy({ it.substringBefore(stringDelimiter) }, { it.substringAfter(stringDelimiter) })
            }
}