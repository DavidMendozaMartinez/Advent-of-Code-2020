package day_05

import Day
import Reader

fun main() {
    Day05().solve()
}

class Day05(reader: Reader<List<String>> = Day05Reader()) : Day<Int, Int>("05") {
    private val boardingPasses: List<String> = reader.read()

    override fun solvePart1(): Int = boardingPasses.maxOf { getSeatID(it) }

    override fun solvePart2(): Int {
        val ids = boardingPasses.map { getSeatID(it) }.sorted()
        return (ids.first()..ids.last()).subtract(ids).first()
    }

    private fun getSeatID(boardingPass: String): Int = boardingPass
        .replace("[FL]".toRegex(), "0")
        .replace("[BR]".toRegex(), "1")
        .toInt(2)
}