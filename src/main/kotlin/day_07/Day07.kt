package day_07

import Day
import Reader

fun main() {
    Day07().solve()
}

class Day07(reader: Reader<RuleMap> = Day07Reader()) : Day<Int, Int>("07") {
    private val ruleMap: RuleMap = reader.read()

    companion object {
        const val COLOR = "shiny gold"
    }

    override fun solvePart1(): Int = ruleMap.getPotentialParents(COLOR).size

    override fun solvePart2(): Int = ruleMap.countPotentialChildren(COLOR)

    class RuleMap(private val map: Map<String, Set<Pair<Int, String>>>) {

        companion object {
            fun parse(rules: List<String>): RuleMap =
                RuleMap(rules.associate {
                    val color = it.substringBefore(":")
                    val content = it.substringAfter(":")
                        .split(", ")
                        .map { quantity -> quantity.partition(Char::isDigit).run { first.toInt() to second.trim() } }
                        .toSet()
                    color to content
                })
        }

        fun getPotentialParents(color: String, parents: MutableSet<String> = mutableSetOf()): Set<String> {
            with(getParents(color)) {
                forEach { parents += getPotentialParents(it, this.toMutableSet()) }
            }
            return parents
        }

        private fun getParents(color: String): Set<String> =
            map.filterValues { content -> content.any { it.second == color } }.keys

        fun countPotentialChildren(color: String): Int =
            with(getChildren(color)) {
                fold(map { it.first }.sum()) { acc, pair ->
                    acc + pair.first * countPotentialChildren(pair.second)
                }
            }

        private fun getChildren(color: String): Set<Pair<Int, String>> = map[color] ?: emptySet()
    }
}