package day_01

import Day
import Reader

fun main() {
    Day01().solve()
}

class Day01(reader: Reader<List<Int>> = Day01Reader()) : Day<Int, Int>("01") {
    private val report: List<Int> = reader.read()

    override fun solvePart1(): Int {
        val firstEntry = report.first { report.contains(2020 - it) }
        return firstEntry * (2020 - firstEntry)
    }

    override fun solvePart2(): Int {
        report.forEach { firstEntry ->
            val candidates = report.filter { it <= (2020 - firstEntry) }
            val secondEntry = candidates.firstOrNull { report.contains(2020 - (firstEntry + it)) }
            secondEntry?.let { return firstEntry * secondEntry * (2020 - (firstEntry + secondEntry)) }
        }
        return -1
    }
}