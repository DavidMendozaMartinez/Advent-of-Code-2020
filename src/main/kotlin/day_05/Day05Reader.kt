package day_05

import InputFile
import Reader

class Day05Reader(private val lines: List<String> = InputFile("05").lines) : Reader<List<String>> {
    override fun read(): List<String> = lines
}