package day_07

import Day
import Input

fun main() {
    val dayNumber = "07"
    val input = Input(dayNumber).getStrings {
        this.replace(" bags| bag|\\.".toRegex(), "")
            .replace("no other", "0")
            .replace(" contain ", ":")
    }
    Day07(input).solve(dayNumber)
}

class Day07(var input: List<String> = emptyList()) : Day<Int, Int>() {

    companion object {
        const val COLOR = "shiny gold"
    }

    override fun solvePart1(): Int = RuleMap.parse(input).getPotentialParents(COLOR).size

    override fun solvePart2(): Int = RuleMap.parse(input).countPotentialChildren(COLOR)

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