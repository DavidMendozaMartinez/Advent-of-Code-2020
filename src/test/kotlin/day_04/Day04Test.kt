package day_04

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Day04Test {

    private lateinit var day: Day04

    @Before
    fun setUp() {
        day = Day04()
    }

    @Test
    fun `Day 04 - Part 1 - Expected output when providing the first sample input`() {
        val input = listOf(
            mapOf(
                "ecl" to "gry",
                "pid" to "860033327",
                "eyr" to "2020",
                "hcl" to "#fffffd",
                "byr" to "1937",
                "iyr" to "2017",
                "cid" to "147",
                "hgt" to "183cm"
            ),
            mapOf(
                "iyr" to "2013",
                "ecl" to "amb",
                "cid" to "350",
                "eyr" to "2023",
                "pid" to "028048884",
                "hcl" to "#cfa07d",
                "byr" to "1929"
            ),
            mapOf(
                "hcl" to "#ae17e1",
                "iyr" to "2013",
                "eyr" to "2024",
                "ecl" to "brn",
                "pid" to "760753108",
                "byr" to "1931",
                "hgt" to "179cm"
            ),
            mapOf(
                "hcl" to "#cfa07d",
                "eyr" to "2025",
                "pid" to "166559648",
                "iyr" to "2011",
                "ecl" to "brn",
                "hgt" to "59in"
            )
        )
        day.input = input

        val expected = 2
        assertEquals(expected, day.invokePart1())
    }

    @Test
    fun `Day 04 - Part 2 - Expected output when providing the second sample input (invalid passports)`() {
        val input = listOf(
            mapOf(
                "eyr" to "1972",
                "cid" to "100",
                "hcl" to "#18171d",
                "ecl" to "amb",
                "hgt" to "170",
                "pid" to "186cm",
                "iyr" to "2018",
                "byr" to "1926"
            ),
            mapOf(
                "iyr" to "2019",
                "hcl" to "#602927",
                "eyr" to "1967",
                "hgt" to "170cm",
                "ecl" to "grn",
                "pid" to "012533040",
                "byr" to "1946"
            ),
            mapOf(
                "hcl" to "dab227",
                "iyr" to "2012",
                "ecl" to "brn",
                "hgt" to "182cm",
                "pid" to "021572410",
                "eyr" to "2020",
                "byr" to "1992",
                "cid" to "277"
            ),
            mapOf(
                "hgt" to "59cm",
                "ecl" to "zzz",
                "eyr" to "2038",
                "hcl" to "74454a",
                "iyr" to "2023",
                "pid" to "3556412378",
                "byr" to "2007"
            )
        )
        day.input = input

        val expected = 0
        assertEquals(expected, day.invokePart2())
    }

    @Test
    fun `Day 04 - Part 2 - Expected output when providing the third sample input (valid passports)`() {
        val input = listOf(
            mapOf(
                "pid" to "087499704",
                "hgt" to "74in",
                "ecl" to "grn",
                "iyr" to "2012",
                "eyr" to "2030",
                "byr" to "1980",
                "hcl" to "#623a2f"
            ),
            mapOf(
                "eyr" to "2029",
                "ecl" to "blu",
                "cid" to "129",
                "byr" to "1989",
                "iyr" to "2014",
                "pid" to "896056539",
                "hcl" to "#a97842",
                "hgt" to "165cm"
            ),
            mapOf(
                "hcl" to "#888785",
                "hgt" to "164cm",
                "byr" to "2001",
                "iyr" to "2015",
                "cid" to "88",
                "pid" to "545766238",
                "ecl" to "hzl",
                "eyr" to "2022"
            ),
            mapOf(
                "iyr" to "2010",
                "hgt" to "158cm",
                "hcl" to "#b6652a",
                "ecl" to "blu",
                "byr" to "1944",
                "eyr" to "2021",
                "pid" to "093154719"
            )
        )
        day.input = input

        val expected = 4
        assertEquals(expected, day.invokePart2())
    }
}