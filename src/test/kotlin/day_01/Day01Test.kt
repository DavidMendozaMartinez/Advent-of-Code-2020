package day_01

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day01Test {

    private lateinit var day: Day01

    @Before
    fun setUp() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)
        day = Day01(input)
    }

    @Test
    fun `Day 01 - Part 1 - Expected output when providing sample input`() {
        val expected = 514579
        assertEquals(expected, day.invokePart1())
    }

    @Test
    fun `Day 01 - Part 2 - Expected output when providing sample input`() {
        val expected = 241861950
        assertEquals(expected, day.invokePart2())
    }
}