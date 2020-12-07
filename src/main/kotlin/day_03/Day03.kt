package day_03

import Day
import Input

fun main() {
    val dayNumber = "03"
    val input = Input(dayNumber).getCharMatrix()
    Day03(input).solve(dayNumber)
}

class Day03(private val input: List<List<Char>>) : Day<Int, Long>() {
    companion object {
        const val TREE = '#'
    }

    override fun solvePart1(): Int = countTrees(3 to 1)

    override fun solvePart2(): Long =
        listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { countTrees(it).toLong() }
            .reduce { acc, l -> acc * l }

    private fun countTrees(slope: Pair<Int, Int>): Int {
        var index = -slope.first
        return input
            .slice(input.indices step slope.second)
            .count {
                index = (index + slope.first) % it.size
                it[index] == TREE
            }
    }
}