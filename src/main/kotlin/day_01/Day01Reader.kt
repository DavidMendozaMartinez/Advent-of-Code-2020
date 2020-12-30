package day_01

import InputFile
import Reader

class Day01Reader(private val lines: List<String> = InputFile("01").lines) : Reader<List<Int>> {
    override fun read(): List<Int> = lines.map { it.toInt() }
}