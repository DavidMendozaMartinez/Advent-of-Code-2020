package day_07

import org.junit.Assert.assertEquals
import org.junit.Test

class Day07Test {

    private lateinit var day: Day07

    private val firstSample = listOf(
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    )

    private val secondSample = listOf(
        "shiny gold bags contain 2 dark red bags.",
        "dark red bags contain 2 dark orange bags.",
        "dark orange bags contain 2 dark yellow bags.",
        "dark yellow bags contain 2 dark green bags.",
        "dark green bags contain 2 dark blue bags.",
        "dark blue bags contain 2 dark violet bags.",
        "dark violet bags contain no other bags."
    )

    @Test
    fun `Day 07 - Part 1 - Expected output when providing the first sample input`() {
        day = Day07(Day07Reader(firstSample))

        val expected = 4
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 07 - Part 2 - Expected output when providing the first sample input`() {
        day = Day07(Day07Reader(firstSample))

        val expected = 32
        assertEquals(expected, day.solvePart2())
    }

    @Test
    fun `Day 07 - Part 2 - Expected output when providing the second sample input`() {
        day = Day07(Day07Reader(secondSample))

        val expected = 126
        assertEquals(expected, day.solvePart2())
    }
}