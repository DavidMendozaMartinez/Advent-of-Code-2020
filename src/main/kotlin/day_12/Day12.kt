package day_12

import Day
import Reader
import kotlin.math.abs

fun main() {
    Day12().solve()
}

class Day12(reader: Reader<List<Instruction>> = Day12Reader()) : Day<Int, Int>("12") {
    private val instructions: List<Instruction> = reader.read()

    override fun solvePart1(): Int =
        Navigation(facing = Direction.EAST, execution = ::interpret).apply { run(instructions) }.manhattanDistance()

    override fun solvePart2(): Int =
        Navigation(facing = Direction.EAST, waypoint = Position(10, 1)).apply { run(instructions) }.manhattanDistance()

    private fun interpret(navigation: Navigation, instruction: Instruction): Unit = with(navigation) {
        when (instruction.action) {
            Action.N -> ship.y += instruction.value
            Action.S -> ship.y -= instruction.value
            Action.E -> ship.x += instruction.value
            Action.W -> ship.x -= instruction.value
            Action.L -> facing = facing.left(instruction.value / 90)
            Action.R -> facing = facing.right(instruction.value / 90)
            Action.F -> interpret(this, Instruction(Action.valueOf(facing.name.take(1)), instruction.value))
        }
    }

    class Navigation(
        var facing: Direction,
        var ship: Position = Position(),
        var waypoint: Position = Position(),
        var execution: (Navigation, Instruction) -> Unit = Navigation::execute,
    ) {
        fun run(instructions: List<Instruction>) = instructions.forEach { execution(this, it) }

        private fun execute(instruction: Instruction) {
            when (instruction.action) {
                Action.N -> waypoint.y += instruction.value
                Action.S -> waypoint.y -= instruction.value
                Action.E -> waypoint.x += instruction.value
                Action.W -> waypoint.x -= instruction.value
                Action.L -> repeat(instruction.value / 90) { waypoint = Position(-waypoint.y, waypoint.x) }
                Action.R -> repeat(instruction.value / 90) { waypoint = Position(waypoint.y, -waypoint.x) }
                Action.F -> ship.apply {
                    x += waypoint.x * instruction.value
                    y += waypoint.y * instruction.value
                }
            }
        }

        fun manhattanDistance(starting: Position = Position()): Int =
            abs(ship.x - starting.x) + abs(ship.y - starting.y)
    }

    enum class Direction {
        NORTH, EAST, SOUTH, WEST;

        fun left(times: Int): Direction = values()[Math.floorMod(ordinal - times, values().size)]
        fun right(times: Int): Direction = values()[Math.floorMod(ordinal + times, values().size)]
    }

    data class Position(var x: Int = 0, var y: Int = 0)

    class Instruction(val action: Action, val value: Int) {
        companion object {
            fun parse(instructionStr: String): Instruction =
                Instruction(Action.valueOf(instructionStr.take(1)), instructionStr.drop(1).toInt())
        }
    }

    enum class Action { N, S, E, W, L, R, F }
}