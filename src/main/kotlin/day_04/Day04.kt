package day_04

import Day
import Reader

fun main() {
    Day04().solve()
}

class Day04(reader: Reader<List<Map<String, String>>> = Day04Reader()) : Day<Int, Int>("04") {
    private val passports: List<Map<String, String>> = reader.read()

    override fun solvePart1(): Int = passports.count {
        hasAllRequiredFields(it.keys, optional = setOf(Field.CountryID))
    }

    override fun solvePart2(): Int = passports.count {
        val hasRequiredFields = hasAllRequiredFields(it.keys, optional = setOf(Field.CountryID))
        val isEachValueValid = it.all { entry -> Field.parse(entry.key).isValueValid(entry.value) }

        hasRequiredFields && isEachValueValid
    }

    private fun hasAllRequiredFields(keys: Set<String>, optional: Set<Field>): Boolean =
        keys.containsAll(Field.values().map { it.key } - optional.map { it.key })

    enum class Field(val key: String, private val validation: (String) -> Boolean) {
        BirthYear("byr", { it.toInt() in 1920..2002 }),
        IssueYear("iyr", { it.toInt() in 2010..2020 }),
        ExpirationYear("eyr", { it.toInt() in 2020..2030 }),
        Height("hgt", { height ->
            val (number, unit) = height.partition { it.isDigit() }
            when (unit) {
                "cm" -> number.toInt() in 150..193
                "in" -> number.toInt() in 59..76
                else -> false
            }
        }),
        HairColor("hcl", { "#[0-9a-f]{6}".toRegex().matches(it) }),
        EyeColor("ecl", { it in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") }),
        PassportID("pid", { id -> id.length == 9 && id.all { it.isDigit() } }),
        CountryID("cid", { true });

        companion object {
            fun parse(key: String): Field = values().first { it.key == key }
        }

        fun isValueValid(value: String): Boolean = validation(value)
    }
}