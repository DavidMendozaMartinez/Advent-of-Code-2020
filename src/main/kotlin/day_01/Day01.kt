package day_01

import Day
import Input

fun main() {
    val dayNumber = "01"
    val input = Input(dayNumber).getInts()
    Day01(input).solve()
}

class Day01(private val input: List<Int>) : Day<Int, Int>("01") {

    override fun solvePart1(): Int {
        val firstEntry = input.first { input.contains(2020 - it) }
        return firstEntry * (2020 - firstEntry)
    }

    override fun solvePart2(): Int {
        input.forEach { firstEntry ->
            val candidates = input.filter { it <= (2020 - firstEntry) }
            val secondEntry = candidates.firstOrNull { input.contains(2020 - (firstEntry + it)) }
            secondEntry?.let { return firstEntry * secondEntry * (2020 - (firstEntry + secondEntry)) }
        }
        return -1
    }
}