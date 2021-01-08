package day_09

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day09Test {

    private lateinit var day: Day09

    @Before
    fun setUp() {
        val input = listOf(
            "35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102",
            "117", "150", "182", "127", "219", "299", "277", "309", "576"
        )
        day = Day09(Day09Reader(input))
        day.preamble = 5
    }

    @Test
    fun `Day 09 - Part 1 - Expected output when providing sample input`() {
        val expected = 127L
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 09 - Part 2 - Expected output when providing sample input`() {
        val expected = 62L
        assertEquals(expected, day.solvePart2())
    }
}