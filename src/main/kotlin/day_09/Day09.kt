package day_09

import Day
import Reader

fun main() {
    Day09().solve()
}

class Day09(reader: Reader<List<Long>> = Day09Reader()) : Day<Long, Long>("09") {
    private val numbers: List<Long> = reader.read()
    var preamble = 25

    override fun solvePart1(): Long = findFirstInvalid()

    override fun solvePart2(): Long = findContiguousRange(findFirstInvalid()).sorted().run { first() + last() }

    private fun findFirstInvalid(): Long = numbers.windowed(preamble + 1).first { window ->
        val (available, sum) = window.take(preamble) to window.last()
        available.none { available.contains(sum - it) }
    }.last()

    private fun findContiguousRange(invalidNumber: Long): List<Long> = numbers.fold(mutableListOf()) { acc, l ->
        if (acc.sum() == invalidNumber) return acc
        acc.add(l)
        when {
            acc.sum() > invalidNumber -> acc.apply { while (sum() > invalidNumber) removeFirst() }
            else -> acc
        }
    }
}