package day_14

import Day
import Reader
import kotlin.math.pow

fun main() {
    Day14().solve()
}

class Day14(reader: Reader<List<Instruction>> = Day14Reader()) : Day<Long, Long>("14") {
    private val program: List<Instruction> = reader.read()

    override fun solvePart1(): Long = mutableMapOf<Long, Long>().apply {
        program.forEach { instruction ->
            instruction.inserts.forEach { insert ->
                this[insert.address.toLong(2)] = decode(instruction.bitmask, insert.value, 'X').toLong(2)
            }
        }
    }.values.sum()

    override fun solvePart2(): Long = mutableMapOf<Long, Long>().apply {
        program.forEach { instruction ->
            instruction.inserts.forEach { insert ->
                val result = decode(instruction.bitmask, insert.address, '0')
                getAddresses(result).forEach { this[it] = insert.value.toLong(2) }
            }
        }
    }.values.sum()

    private fun decode(bitmask: String, value: String, noChangeRule: Char): String =
        bitmask.foldIndexed("") { index, acc, c -> acc + if (c == noChangeRule) value[index] else c }

    private fun getAddresses(result: String): List<Long> = with(result.count { it == 'X' }) {
        (0 until 2f.pow(this).toInt()).map {
            val binary = it.toString(2).padStart(this, '0')
            binary.fold(result) { acc, c -> acc.replaceFirst('X', c) }.toLong(2)
        }
    }

    class Instruction(val bitmask: String, val inserts: List<Insert>)
    class Insert(val address: String, val value: String)
}