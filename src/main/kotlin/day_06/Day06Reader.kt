package day_06

import InputFile
import Reader

class Day06Reader(private val text: String = InputFile("06").text) : Reader<List<List<String>>> {
    private val groupDelimiter = "\n\n"
    private val answerDelimiter = "\n"

    override fun read(): List<List<String>> = text.split(groupDelimiter).map { it.split(answerDelimiter) }
}