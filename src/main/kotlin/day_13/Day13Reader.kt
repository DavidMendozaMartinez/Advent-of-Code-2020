package day_13

import InputFile
import Reader

class Day13Reader(private val lines: List<String> = InputFile("13").lines) : Reader<Pair<Int, List<String>>> {
    override fun read(): Pair<Int, List<String>> = lines.first().toInt() to lines.last().split(',')
}