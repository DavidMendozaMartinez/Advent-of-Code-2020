package day_06

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day06Test {

    private lateinit var day: Day06

    @Before
    fun setUp() {
        val input = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b"
        day = Day06(Day06Reader(input))
    }

    @Test
    fun `Day 06 - Part 1 - Expected output when providing sample input`() {
        val expected = 11
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 06 - Part 2 - Expected output when providing sample input`() {
        val expected = 6
        assertEquals(expected, day.solvePart2())
    }
}