package day_08

import Day
import Input

fun main() {
    val dayNumber = "08"
    val input = Input(dayNumber).getStringPairs(" ")
    Day08(input).solve(dayNumber)
}

class Day08(input: List<Pair<String, String>>) : Day<Int, Int>() {
    private val bootCode: List<Instruction> = input.map { Instruction.parse(it) }

    override fun solvePart1(): Int = Game().run(bootCode).accumulator

    override fun solvePart2(): Int = Game().run(getFixedBootCode()).accumulator

    class Game {
        private var cursor = 0
        private var accumulator = 0
        private val cursorLog: MutableList<Int> = mutableListOf()

        fun run(code: List<Instruction>): Output {
            while (cursor !in cursorLog) {
                cursorLog.add(cursor)
                code.getOrNull(cursor)?.let { execute(it) } ?: return Output.Success(accumulator)
            }
            return Output.Error(accumulator)
        }

        private fun execute(instruction: Instruction) {
            when (instruction.operation) {
                Operation.ACC -> {
                    accumulator += instruction.argument
                    cursor++
                }
                Operation.JMP -> cursor += instruction.argument
                Operation.NOP -> cursor++
            }
        }

        sealed class Output(val accumulator: Int) {
            class Success(accumulator: Int) : Output(accumulator)
            class Error(accumulator: Int) : Output(accumulator)
        }
    }

    data class Instruction(val operation: Operation, val argument: Int) {
        companion object {
            fun parse(pair: Pair<String, String>): Instruction =
                Instruction(Operation.valueOf(pair.first.toUpperCase()), pair.second.toInt())
        }
    }

    enum class Operation { ACC, JMP, NOP }

    private fun getFixedBootCode(): List<Instruction> {
        bootCode.forEachIndexed { index, instruction ->
            val fix = when (instruction.operation) {
                Operation.ACC -> return@forEachIndexed
                Operation.JMP -> instruction.copy(operation = Operation.NOP)
                Operation.NOP -> instruction.copy(operation = Operation.JMP)
            }
            val code = bootCode.toMutableList().apply { this[index] = fix }
            if (Game().run(code) is Game.Output.Success) return code
        }
        return bootCode
    }
}