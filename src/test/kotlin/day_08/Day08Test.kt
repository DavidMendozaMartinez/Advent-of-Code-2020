package day_08

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day08Test {

    private lateinit var day: Day08

    @Before
    fun setUp() {
        val input = listOf(
            "nop" to "+0",
            "acc" to "+1",
            "jmp" to "+4",
            "acc" to "+3",
            "jmp" to "-3",
            "acc" to "-99",
            "acc" to "+1",
            "jmp" to "-4",
            "acc" to "+6"
        )
        day = Day08(input)
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