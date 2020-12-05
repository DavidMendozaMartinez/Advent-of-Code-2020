package day_04

import Day
import Input

fun main() {
    val dayNumber = "04"
    val input = Input(dayNumber).getStringMapList(
        elementDelimiter = "\n\n",
        pairDelimiter = arrayOf(" ", "\n"),
        stringDelimiter = ":"
    )
    val day = Day04(input)

    println("Day $dayNumber (Part 1) - Answer: ${day.invokePart1()}")
    println("Day $dayNumber (Part 2) - Answer: ${day.invokePart2()}")
}

class Day04(var input: List<Map<String, String>> = emptyList()) : Day<Int, Int>() {

    override fun invokePart1(): Int = input.count {
        hasAllRequiredFields(it.keys, optional = setOf(Field.CountryID))
    }

    override fun invokePart2(): Int = input.count {
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
        HairColor("hcl", { color ->
            color.length == 7 && color.first() == '#' && color.takeLast(6).toLongOrNull(16)?.let { true } ?: false
        }),
        EyeColor("ecl", { it in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") }),
        PassportID("pid", { id -> id.length == 9 && id.all { it.isDigit() } }),
        CountryID("cid", { true });

        companion object {
            fun parse(key: String): Field = values().first { it.key == key }
        }

        fun isValueValid(value: String): Boolean = validation(value)
    }
}