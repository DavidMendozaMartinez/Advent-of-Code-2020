package day_10

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day10Test {

    private lateinit var day: Day10

    private val firstSample = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
    private val secondSample = listOf(
        28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19,
        38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3
    )

    @Before
    fun setUp() {
        day = Day10()
    }

    @Test
    fun `Day 10 - Part 1 - Expected output when providing the first sample input`() {
        day.input = firstSample

        val expected = 35
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 10 - Part 1 - Expected output when providing the second sample input`() {
        day.input = secondSample

        val expected = 220
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 10 - Part 2 - Expected output when providing the first sample input`() {
        day.input = firstSample

        val expected = 8L
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 10 - Part 2 - Expected output when providing the second sample input`() {
        day.input = secondSample

        val expected = 19208L
        assertEquals(expected, day.solvePart2())
    }
}