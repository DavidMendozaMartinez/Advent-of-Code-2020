package day_11

import Day
import Input
import kotlin.properties.Delegates

private typealias Seat = Pair<Int, Int>

fun main() {
    val dayNumber = "11"
    val input = Input(dayNumber).getCharMatrix()
    Day11(input).solve()
}

class Day11(private val input: List<List<Char>>) : Day<Int, Int>("11") {

    override fun solvePart1(): Int =
        SeatLayout(input, Rule(4, ::getAdjacent)).apply { stabilize() }.countOccupiedSeats()

    override fun solvePart2(): Int =
        SeatLayout(input, Rule(5, ::getFirstVisible)).apply { stabilize() }.countOccupiedSeats()

    private fun getAdjacent(seat: Seat, seats: List<Seat>): List<Seat> = mutableListOf<Seat>().apply {
        listOf(0 to 1, 1 to 1, 1 to 0, 1 to -1, 0 to -1, -1 to -1, -1 to 0, -1 to 1).forEach {
            with(it.first + seat.first to it.second + seat.second) { if (seats.contains(this)) add(this) }
        }
    }

    private fun getFirstVisible(seat: Seat, seats: List<Seat>): List<Seat> = mutableListOf<Seat>().apply {
        listOf(seats.indexOf(seat) - 1 downTo 0, seats.indexOf(seat) + 1..seats.lastIndex).forEach { range ->
            with(seats.slice(range)) {
                firstOrNull { it.first == seat.first }?.let { add(it) }
                firstOrNull { it.second == seat.second }?.let { add(it) }
                firstOrNull { it.first - it.second == seat.first - seat.second }?.let { add(it) }
                firstOrNull { it.first + it.second == seat.first + seat.second }?.let { add(it) }
            }
        }
    }

    class Rule(val minOccupied: Int, val getSeatsAround: (Seat, List<Seat>) -> List<Seat>)

    class SeatLayout(private val initial: List<List<Char>>, private val rule: Rule) {
        companion object {
            const val FLOOR = '.'
            const val EMPTY = 'L'
            const val OCCUPIED = '#'
        }

        private var layout by Delegates.observable(initial) { _, old, new -> isStabilized = old == new }
        private val seats = mutableListOf<Seat>().apply {
            initial.forEachIndexed { row, columns ->
                columns.forEachIndexed { column, char -> if (char != FLOOR) add(row to column) }
            }
        }
        private val seatsAround = seats.associateWith { rule.getSeatsAround(it, seats) }
        private var isStabilized = false

        fun stabilize() {
            while (!isStabilized) {
                layout = applyRules()
            }
        }

        private fun applyRules(): List<List<Char>> = layout.map { it.toMutableList() }.apply {
            seats.forEach { seat ->
                val aroundOccupied = countOccupiedSeats(seatsAround[seat]!!)
                when {
                    !isSeatOccupied(seat) && aroundOccupied == 0 -> this[seat.first][seat.second] = OCCUPIED
                    isSeatOccupied(seat) && aroundOccupied >= rule.minOccupied -> this[seat.first][seat.second] = EMPTY
                }
            }
        }

        fun countOccupiedSeats(seats: List<Seat> = this.seats): Int = seats.count { isSeatOccupied(it) }
        private fun isSeatOccupied(seat: Seat): Boolean = layout[seat.first][seat.second] == OCCUPIED
    }
}