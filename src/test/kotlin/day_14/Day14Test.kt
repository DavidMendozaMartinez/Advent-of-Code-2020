package day_14

import org.junit.Assert.assertEquals
import org.junit.Test

class Day14Test {

    private lateinit var day: Day14

    @Test
    fun `Day 14 - Part 1 - Expected output when providing the first sample input`() {
        val input = "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\n" +
                "mem[8] = 11\n" +
                "mem[7] = 101\n" +
                "mem[8] = 0"
        day = Day14(Day14Reader(input))

        val expected = 165L
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 14 - Part 2 - Expected output when providing the second sample input`() {
        val input = "mask = 000000000000000000000000000000X1001X\n" +
                "mem[42] = 100\n" +
                "mask = 00000000000000000000000000000000X0XX\n" +
                "mem[26] = 1"
        day = Day14(Day14Reader(input))

        val expected = 208L
        assertEquals(expected, day.solvePart2())
    }
}