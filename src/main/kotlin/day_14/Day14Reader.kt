package day_14

import InputFile
import Reader
import day_14.Day14.Insert
import day_14.Day14.Instruction

class Day14Reader(private val text: String = InputFile("14").text) : Reader<List<Instruction>> {
    private val mask: Regex = "mask = [01X]+".toRegex()
    private val mem: Regex = "mem\\[\\d+] = \\d+".toRegex()
    private val instruction: Regex = "$mask\n($mem\n)*$mem".toRegex()

    override fun read(): List<Instruction> = instruction.findAll(text).map { match ->
        val bitmask = mask.find(match.value)!!.value.substringAfter("mask = ")
        val inserts = mem.findAll(match.value).toList().map { result ->
            val address = result.value.substringBefore(" = ").filter { it.isDigit() }.toLong()
            val value = result.value.substringAfter(" = ").toLong()

            Insert(
                address.toString(2).padStart(36, '0'),
                value.toString(2).padStart(36, '0')
            )
        }
        Instruction(bitmask, inserts)
    }.toList()
}