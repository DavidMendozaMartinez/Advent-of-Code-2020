package day_06

import Day
import Reader

fun main() {
    Day06().solve()
}

class Day06(reader: Reader<List<List<String>>> = Day06Reader()) : Day<Int, Int>("06") {
    private val answers: List<List<String>> = reader.read()

    override fun solvePart1(): Int = answers.sumBy { it.joinToString("").toSet().size }

    override fun solvePart2(): Int = answers.sumBy { group ->
        group.map { it.toSet() }.reduce { acc, set -> acc.intersect(set) }.size
    }
}