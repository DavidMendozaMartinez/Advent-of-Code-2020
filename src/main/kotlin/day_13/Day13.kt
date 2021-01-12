package day_13

import Day
import Reader

fun main() {
    Day13().solve()
}

class Day13(reader: Reader<Pair<Int, List<String>>> = Day13Reader()) : Day<Int, Long>("13") {
    private val earliestTimestamp: Int = reader.read().first
    private val ids: List<String> = reader.read().second
    private val inService: List<Int> = ids.filter { it != "x" }.map { it.toInt() }

    override fun solvePart1(): Int =
        inService.minByOrNull { it - earliestTimestamp % it }!!.let { it * (it - earliestTimestamp % it) }

    override fun solvePart2(): Long {
        val (index, departures) = getDeparturesByTime().maxByOrNull { it.value.fold(1) { acc, i -> acc * i } }!!
        val seed = departures.fold(1L) { acc, i -> acc * i }
        val conditions: List<(Long) -> Boolean> = (inService - departures).map {
            { time -> (time - (index - ids.indexOf(it.toString()))) % it == 0L }
        }
        return generateSequence(seed) { it + seed }.first { time -> conditions.all { it(time) } } - index
    }

    private fun getDeparturesByTime(): Map<Int, List<Int>> = ids.indices.associateWith { getDepartures(it) }

    private fun getDepartures(time: Int): List<Int> = inService.fold(mutableListOf()) { departures, id ->
        departures.apply { if ((time % id) == ids.indexOf(id.toString()) % id) add(id) }
    }
}