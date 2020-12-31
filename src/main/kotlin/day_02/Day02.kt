package day_02

import Day
import Reader

fun main() {
    Day02().solve()
}

class Day02(reader: Reader<List<Pair<String, String>>> = Day02Reader()) : Day<Int, Int>("02") {
    private val corruptedDatabase: List<Pair<String, String>> = reader.read()

    override fun solvePart1(): Int = corruptedDatabase.count {
        val policy = Policy.parse<Policy.ByRange>(it.first)
        policy.isPasswordValid(it.second)
    }

    override fun solvePart2(): Int = corruptedDatabase.count {
        val policy = Policy.parse<Policy.ByPosition>(it.first)
        policy.isPasswordValid(it.second)
    }

    sealed class Policy {
        abstract fun isPasswordValid(password: String): Boolean

        class ByRange(private val first: Int, private val second: Int, private val letter: Char) : Policy() {
            override fun isPasswordValid(password: String): Boolean = password.count { it == letter } in first..second
        }

        class ByPosition(private val first: Int, private val second: Int, private val letter: Char) : Policy() {
            override fun isPasswordValid(password: String): Boolean =
                (password[first - 1] == letter) xor (password[second - 1] == letter)
        }

        companion object {
            inline fun <reified T : Policy> parse(policyStr: String): Policy {
                val numbers = policyStr.dropLast(2).split('-').map { it.toInt() }

                return when (T::class) {
                    ByRange::class -> ByRange(numbers[0], numbers[1], policyStr.last())
                    else -> ByPosition(numbers[0], numbers[1], policyStr.last())
                }
            }
        }
    }
}