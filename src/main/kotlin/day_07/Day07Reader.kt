package day_07

import InputFile
import Reader
import day_07.Day07.RuleMap

class Day07Reader(private val lines: List<String> = InputFile("07").lines) : Reader<RuleMap> {
    override fun read(): RuleMap = RuleMap.parse(
        lines.map {
            it.replace(" bags| bag|\\.".toRegex(), "")
                .replace(" contain ", ":")
                .replace("no other", "0")
        }
    )
}