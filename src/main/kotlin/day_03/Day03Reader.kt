package day_03

import InputFile
import Reader

class Day03Reader(private val lines: List<String> = InputFile("03").lines) : Reader<List<List<Char>>> {
    override fun read(): List<List<Char>> = lines.map { it.toList() }
}