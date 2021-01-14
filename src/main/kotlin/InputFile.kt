import java.io.File

class InputFile(dayNumber: String) {
    private val file = File("src/main/kotlin/day_$dayNumber/input.txt")

    var text: String = file.readText()
    var lines: List<String> = file.readLines()
}