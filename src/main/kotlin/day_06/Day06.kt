package day_06

import Day
import Input

fun main() {
    val dayNumber = "06"
    val input = Input(dayNumber).getStringGroupList(elementDelimiter = "\n\n", stringDelimiter = "\n")
    Day06(input).solve(dayNumber)
}

class Day06(private val input: List<List<String>>) : Day<Int, Int>() {

    override fun solvePart1(): Int = input.sumBy { it.joinToString("").toSet().size }

    override fun solvePart2(): Int = input.sumBy { group ->
        group.map { it.toSet() }.reduce { acc, set -> acc.intersect(set) }.size
    }
}