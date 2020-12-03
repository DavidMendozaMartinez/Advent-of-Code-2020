package day_03

import Day
import Input

fun main() {
    val dayNumber = "03"
    val input = Input(dayNumber).getCharMatrix()
    val day = Day03(input)

    println("Day $dayNumber (Part 1) - Answer: ${day.invokePart1()}")
    println("Day $dayNumber (Part 2) - Answer: ${day.invokePart2()}")
}

class Day03(private val input: List<List<Char>>) : Day<Int, Long>() {
    companion object {
        const val TREE = '#'
    }

    override fun invokePart1(): Int = countTrees(3 to 1)

    override fun invokePart2(): Long =
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