package day_06

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day06Test {

    private lateinit var day: Day06

    @Before
    fun setUp() {
        val input = listOf(
            listOf("abc"),
            listOf("a", "b", "c"),
            listOf("ab", "ac"),
            listOf("a", "a", "a", "a"),
            listOf("b")
        )
        day = Day06(input)
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