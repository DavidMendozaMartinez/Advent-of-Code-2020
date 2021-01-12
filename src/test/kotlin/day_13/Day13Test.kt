package day_13

import org.junit.Assert.assertEquals
import org.junit.Test

class Day13Test {

    private lateinit var day: Day13
    private val firstSample = listOf("939", "7,13,x,x,59,x,31,19")

    @Test
    fun `Day 13 - Part 1 - Expected output when providing the first sample input`() {
        day = Day13(Day13Reader(firstSample))

        val expected = 295
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 13 - Part 2 - Expected output when providing the first sample input`() {
        day = Day13(Day13Reader(firstSample))

        val expected = 1068781L
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 13 - Part 2 - Expected output when providing the second sample input`() {
        val input = listOf("0", "17,x,13,19")
        day = Day13(Day13Reader(input))

        val expected = 3417L
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 13 - Part 2 - Expected output when providing the third sample input`() {
        val input = listOf("0", "67,7,59,61")
        day = Day13(Day13Reader(input))

        val expected = 754018L
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 13 - Part 2 - Expected output when providing the fourth sample input`() {
        val input = listOf("0", "67,x,7,59,61")
        day = Day13(Day13Reader(input))

        val expected = 779210L
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 13 - Part 2 - Expected output when providing the fifth sample input`() {
        val input = listOf("0", "67,7,x,59,61")
        day = Day13(Day13Reader(input))

        val expected = 1261476L
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 13 - Part 2 - Expected output when providing the sixth sample input`() {
        val input = listOf("0", "1789,37,47,1889")
        day = Day13(Day13Reader(input))

        val expected = 1202161486L
        assertEquals(expected, day.solvePart2())
    }
}