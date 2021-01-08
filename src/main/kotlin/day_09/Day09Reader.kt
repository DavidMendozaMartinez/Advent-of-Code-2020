package day_09

import InputFile
import Reader

class Day09Reader(private val lines: List<String> = InputFile("09").lines) : Reader<List<Long>> {
    override fun read(): List<Long> = lines.map { it.toLong() }
}