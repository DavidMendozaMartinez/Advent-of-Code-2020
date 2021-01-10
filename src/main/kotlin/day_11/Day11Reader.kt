package day_11

import InputFile
import Reader

class Day11Reader(private val lines: List<String> = InputFile("11").lines) : Reader<List<List<Char>>> {
    override fun read(): List<List<Char>> = lines.map { it.toList() }
}