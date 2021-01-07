package day_08

import InputFile
import Reader
import day_08.Day08.Instruction

class Day08Reader(private val lines: List<String> = InputFile("08").lines) : Reader<List<Instruction>> {
    private val delimiter = " "

    override fun read(): List<Instruction> =
        lines.map { Instruction.parse(it.substringBefore(delimiter) to it.substringAfter(delimiter)) }
}