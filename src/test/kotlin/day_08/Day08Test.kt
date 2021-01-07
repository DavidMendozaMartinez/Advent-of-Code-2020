package day_08

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day08Test {

    private lateinit var day: Day08

    @Before
    fun setUp() {
        val input = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )
        day = Day08(Day08Reader(input))
    }

    @Test
    fun `Day 08 - Part 1 - Expected output when providing sample input`() {
        val expected = 5
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 08 - Part 2 - Expected output when providing sample input`() {
        val expected = 8
        assertEquals(expected, day.solvePart2())
    }
}