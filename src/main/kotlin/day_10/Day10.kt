package day_10

import Day
import Reader
import kotlin.math.pow

fun main() {
    Day10().solve()
}

class Day10(reader: Reader<List<Int>> = Day10Reader()) : Day<Int, Long>("10") {
    private val ratings: List<Int> = reader.read()

    override fun solvePart1(): Int =
        ratings.partition { ratings.contains(it + 1) }.run { first.size * second.size }

    override fun solvePart2(): Long = with(ratings.toMutableList()) {
        listOf(5 to 7, 3 to 2).fold(1) { count, pair ->
            val consecutive = findConsecutive(pair.first)
            consecutive.forEach { removeAll(it) }
            count * pair.second.pow(consecutive.size)
        }
    }

    private fun List<Int>.findConsecutive(size: Int): List<List<Int>> = windowed(size).filter { it.isConsecutive() }
    private fun List<Int>.isConsecutive(): Boolean = last() - first() == size - 1
    private fun Int.pow(exponent: Int): Long = toDouble().pow(exponent).toLong()
}