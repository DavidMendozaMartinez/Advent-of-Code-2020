package day_03

import Day
import Reader

fun main() {
    Day03().solve()
}

class Day03(reader: Reader<List<List<Char>>> = Day03Reader()) : Day<Int, Long>("03") {
    private val map: List<List<Char>> = reader.read()

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
        return map
            .slice(map.indices step slope.second)
            .count {
                index = (index + slope.first) % it.size
                it[index] == TREE
            }
    }
}