package day_02

import Day
import Input

fun main() {
    val dayNumber = "02"
    val input = Input(dayNumber).getStringPairs(": ")
    Day02(input).solve(dayNumber)
}

class Day02(private val input: List<Pair<String, String>>) : Day<Int, Int>() {

    override fun solvePart1(): Int = input.count {
        val policy = Policy.parse<Policy.ByRange>(it.first)
        policy.isPasswordValid(it.second)
    }

    override fun solvePart2(): Int = input.count {
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