package day_12

import InputFile
import Reader
import day_12.Day12.Instruction

class Day12Reader(private val lines: List<String> = InputFile("12").lines) : Reader<List<Instruction>> {
    override fun read(): List<Instruction> = lines.map { Instruction.parse(it) }
}