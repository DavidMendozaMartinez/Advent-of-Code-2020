package day_02

import InputFile
import Reader

class Day02Reader(private val lines: List<String> = InputFile("02").lines) : Reader<List<Pair<String, String>>> {
    private val delimiter = ": "

    override fun read(): List<Pair<String, String>> =
        lines.map { it.substringBefore(delimiter) to it.substringAfter(delimiter) }
}