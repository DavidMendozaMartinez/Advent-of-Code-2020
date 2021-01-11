package day_12

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day12Test {

    private lateinit var day: Day12

    @Before
    fun setUp() {
        val input = listOf("F10", "N3", "F7", "R90", "F11")
        day = Day12(Day12Reader(input))
    }

    @Test
    fun `Day 12 - Part 1 - Expected output when providing sample input`() {
        val expected = 25
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 12 - Part 2 - Expected output when providing sample input`() {
        val expected = 286
        assertEquals(expected, day.solvePart2())
    }
}