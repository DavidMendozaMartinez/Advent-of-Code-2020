package day_02

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day02Test {

    private lateinit var day: Day02

    @Before
    fun setUp() {
        val input = listOf("1-3 a" to "abcde", "1-3 b" to "cdefg", "2-9 c" to "ccccccccc")
        day = Day02(input)
    }

    @Test
    fun `Day 02 - Part 1 - Expected output when providing sample input`() {
        val expected = 2
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 02 - Part 2 - Expected output when providing sample input`() {
        val expected = 1
        assertEquals(expected, day.solvePart2())
    }
}