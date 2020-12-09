package day_07

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day07Test {

    private lateinit var day: Day07

    private val firstSample = listOf(
        "light red:1 bright white, 2 muted yellow",
        "dark orange:3 bright white, 4 muted yellow",
        "bright white:1 shiny gold",
        "muted yellow:2 shiny gold, 9 faded blue",
        "shiny gold:1 dark olive, 2 vibrant plum",
        "dark olive:3 faded blue, 4 dotted black",
        "vibrant plum:5 faded blue, 6 dotted black",
        "faded blue:0",
        "dotted black:0"
    )

    private val secondSample = listOf(
        "shiny gold:2 dark red",
        "dark red:2 dark orange",
        "dark orange:2 dark yellow",
        "dark yellow:2 dark green",
        "dark green:2 dark blue",
        "dark blue:2 dark violet",
        "dark violet:0"
    )

    @Before
    fun setUp() {
        day = Day07()
    }

    @Test
    fun `Day 07 - Part 1 - Expected output when providing the first sample input`() {
        day.input = firstSample

        val expected = 4
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 07 - Part 2 - Expected output when providing the first sample input`() {
        day.input = firstSample

        val expected = 32
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 07 - Part 2 - Expected output when providing the second sample input`() {
        day.input = secondSample

        val expected = 126
        assertEquals(expected, day.solvePart2())
    }
}