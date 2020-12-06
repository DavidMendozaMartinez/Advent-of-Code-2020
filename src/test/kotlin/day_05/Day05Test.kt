package day_05

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day05Test {

    private lateinit var day: Day05

    @Before
    fun setUp() {
        day = Day05()
    }

    @Test
    fun `Day 05 - Part 1 - Expected output when providing the first sample input`() {
        val input = listOf("FBFBBFFRLR", "BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")
        day.input = input

        val expected = 820
        assertEquals(expected, day.invokePart1())
    }

    @Test
    fun `Day 05 - Part 2 - Expected output when providing the second sample input`() {
        val input = listOf("FBFBBFFLRR", "FBFBBFFRLL", "FBFBBFFRRL", "FBFBBFFRRR")
        day.input = input

        val expected = 357
        assertEquals(expected, day.invokePart2())
    }
}