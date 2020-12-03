package day_02

import Day
import Input

fun main() {
    val dayNumber = "02"
    val input = Input(dayNumber).getStringPairs(": ")
    val day = Day02(input)

    println("Day $dayNumber (Part 1) - Answer: ${day.invokePart1()}")
    println("Day $dayNumber (Part 2) - Answer: ${day.invokePart2()}")
}

class Day02(private val input: List<Pair<String, String>>) : Day<Int, Int>() {

    override fun invokePart1(): Int = input.count {
        val policy = getPolicyFromString<Policy.ByRange>(it.first)
        policy.isPasswordValid(it.second)
    }

    override fun invokePart2(): Int = input.count {
        val policy = getPolicyFromString<Policy.ByPosition>(it.first)
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
    }

    private inline fun <reified T : Policy> getPolicyFromString(policyStr: String): Policy {
        val numbers = policyStr.dropLast(2).split('-').map { it.toInt() }

        return when (T::class) {
            Policy.ByRange::class -> Policy.ByRange(numbers[0], numbers[1], policyStr.last())
            else -> Policy.ByPosition(numbers[0], numbers[1], policyStr.last())
        }
    }
}