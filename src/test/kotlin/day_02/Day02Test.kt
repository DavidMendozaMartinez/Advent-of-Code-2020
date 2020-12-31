package day_02

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day02Test {

    private lateinit var day: Day02

    @Before
    fun setUp() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        day = Day02(Day02Reader(input))
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