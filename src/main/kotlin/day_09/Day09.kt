package day_09

import Day
import Input

fun main() {
    val dayNumber = "09"
    val input = Input(dayNumber).getLongs()
    Day09(input).solve(dayNumber)
}

class Day09(private val input: List<Long>) : Day<Long, Long>() {
    var preamble = 25

    override fun solvePart1(): Long = findFirstInvalid()

    override fun solvePart2(): Long = findContiguousRange(findFirstInvalid()).sorted().run { first() + last() }

    private fun findFirstInvalid(): Long = input.windowed(preamble + 1).first { window ->
        val (available, sum) = window.take(preamble) to window.last()
        available.none { available.contains(sum - it) }
    }.last()

    private fun findContiguousRange(invalidNumber: Long): List<Long> = input.fold(mutableListOf()) { acc, l ->
        if (acc.sum() == invalidNumber) return acc
        acc.add(l)
        when {
            acc.sum() > invalidNumber -> acc.apply { while (sum() > invalidNumber) removeFirst() }
            else -> acc
        }
    }
}