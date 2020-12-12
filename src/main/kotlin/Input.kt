import java.io.File

class Input(day: String) {
    private val file = File("src/main/kotlin/day_$day/input.txt")

    fun getStrings(block: String.() -> String = { this }): List<String> = file.readLines().map(block)

    fun getInts(): List<Int> = file.readLines().map { it.toInt() }

    fun getLongs(): List<Long> = file.readLines().map { it.toLong() }

    fun getSplitStrings(vararg delimiters: Char): List<String> = file.readText().split(*delimiters)

    fun getSplitInts(vararg delimiters: Char): List<Int> = file.readText().split(*delimiters).map { it.toInt() }

    fun getStringPairs(delimiter: String): List<Pair<String, String>> =
        file.readLines().map { it.substringBefore(delimiter) to it.substringAfter(delimiter) }

    fun getCharMatrix(): List<List<Char>> = file.readLines().map { it.toList() }

    fun getStringGroupList(elementDelimiter: String, stringDelimiter: String): List<List<String>> =
        file.readText().split(elementDelimiter).map { it.split(stringDelimiter) }

    fun getStringMapList(
        elementDelimiter: String,
        vararg pairDelimiter: String,
        stringDelimiter: String
    ): List<Map<String, String>> =
        file.readText()
            .split(elementDelimiter)
            .map { element ->
                element
                    .split(*pairDelimiter)
                    .associateBy({ it.substringBefore(stringDelimiter) }, { it.substringAfter(stringDelimiter) })
            }
}