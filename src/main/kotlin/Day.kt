abstract class Day<out A, out B> {
    abstract fun solvePart1(): A
    abstract fun solvePart2(): B

    fun solve(dayNumber: String) {
        println("Day $dayNumber (Part 1) - Answer: ${solvePart1()}")
        println("Day $dayNumber (Part 2) - Answer: ${solvePart2()}")
    }
}