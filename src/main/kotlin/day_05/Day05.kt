package day_05

import Day
import Input

fun main() {
    val dayNumber = "05"
    val input = Input(dayNumber).getStrings()
    val day = Day05(input)

    println("Day $dayNumber (Part 1) - Answer: ${day.invokePart1()}")
    println("Day $dayNumber (Part 2) - Answer: ${day.invokePart2()}")
}

class Day05(var input: List<String> = emptyList()) : Day<Int, Int>() {

    companion object {
        val ROW_RANGE = 0..127
        val COLUMN_RANGE = 0..7
        const val ROW_UPPER_HALF_RULE = 'B'
        const val COLUMN_UPPER_HALF_RULE = 'R'
    }

    override fun invokePart1(): Int = input.maxOf { getSeatID(it) }

    override fun invokePart2(): Int {
        val ids = input.map { getSeatID(it) }.sorted()
        return (ids.first()..ids.last()).subtract(ids).first()
    }

    private fun getSeatID(boardingPass: String): Int {
        val (rowSequence, columnSequence) = boardingPass.take(7) to boardingPass.takeLast(3)
        val row = decodeSequence(rowSequence, ROW_RANGE, ROW_UPPER_HALF_RULE)
        val column = decodeSequence(columnSequence, COLUMN_RANGE, COLUMN_UPPER_HALF_RULE)
        return row * 8 + column
    }

    private fun decodeSequence(sequence: String, startingRange: IntRange, upperHalfRule: Char): Int =
        sequence.fold(startingRange) { acc, c -> if (c == upperHalfRule) acc.upperHalf() else acc.lowerHalf() }.first

    private fun IntRange.upperHalf(): IntRange = count() / 2 + first..last
    private fun IntRange.lowerHalf(): IntRange = first until count() / 2 + first
}