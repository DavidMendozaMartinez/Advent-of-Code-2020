package day_11

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day11Test {

    private lateinit var day: Day11

    @Before
    fun setUp() {
        val rawInput = listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        )
        val input = rawInput.map { it.toList() }
        day = Day11(input)
    }

    @Test
    fun `Day 11 - Part 1 - Expected output when providing sample input`() {
        val expected = 37
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 11 - Part 2 - Expected output when providing sample input`() {
        val expected = 26
        assertEquals(expected, day.solvePart2())
    }
}