package day_04

import InputFile
import Reader

class Day04Reader(private val text: String = InputFile("04").text) : Reader<List<Map<String, String>>> {
    private val passportDelimiter = "\n\n"
    private val fieldDelimiter = arrayOf(" ", "\n")
    private val entryDelimiter = ":"

    override fun read(): List<Map<String, String>> =
        text.split(passportDelimiter)
            .map { element ->
                element
                    .split(*fieldDelimiter)
                    .associateBy({ it.substringBefore(entryDelimiter) }, { it.substringAfter(entryDelimiter) })
            }
}