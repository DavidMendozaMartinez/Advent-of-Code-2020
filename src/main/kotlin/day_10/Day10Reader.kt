package day_10

import InputFile
import Reader

class Day10Reader(private val lines: List<String> = InputFile("10").lines) : Reader<List<Int>> {
    override fun read(): List<Int> = lines.map { it.toInt() }.toMutableList().apply { add(0) }.sorted()
}