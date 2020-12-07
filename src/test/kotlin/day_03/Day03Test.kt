package day_03

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day03Test {

    private lateinit var day: Day03

    @Before
    fun setUp() {
        val rawInput = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )
        val input = rawInput.map { it.toList() }
        day = Day03(input)
    }

    @Test
    fun `Day 03 - Part 1 - Expected output when providing sample input`() {
        val expected = 7
        assertEquals(expected, day.solvePart1())
    }

    @Test
    fun `Day 03 - Part 2 - Expected output when providing sample input`() {
        val expected = 336L
        assertEquals(expected, day.solvePart2())
    }
}