package day_05

import Day
import Input

fun main() {
    val dayNumber = "05"
    val input = Input(dayNumber).getStrings()
    Day05(input).solve(dayNumber)
}

class Day05(var input: List<String> = emptyList()) : Day<Int, Int>() {

    override fun solvePart1(): Int = input.maxOf { getSeatID(it) }

    override fun solvePart2(): Int {
        val ids = input.map { getSeatID(it) }.sorted()
        return (ids.first()..ids.last()).subtract(ids).first()
    }

    private fun getSeatID(boardingPass: String): Int = boardingPass
        .replace("[FL]".toRegex(), "0")
        .replace("[BR]".toRegex(), "1")
        .toInt(2)
}