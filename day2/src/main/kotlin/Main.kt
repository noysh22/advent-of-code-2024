package advent.ofcode.day2

import kotlin.math.abs

fun isSafe(numbers: List<Int>): Boolean {
    val isIncreasing = numbers.zipWithNext().all { (a, b) -> b >= a }
    val isDecreasing = numbers.zipWithNext().all { (a, b) -> b <= a }

    if (!isIncreasing && !isDecreasing) return false

    return numbers.zipWithNext().all { (a, b) ->
        val diff = abs(b - a)
        diff in 1..3
    }
}

fun isSafeDampened(numbers: List<Int>): Boolean {
    for (i in numbers.indices) {
        val modifiedList = numbers.filterIndexed { index, _ -> index != i }
        if (isSafe(modifiedList)) return true
    }

    // If the original sequence is valid, return true
    return isSafe(numbers)
}

fun main() {
    val input = object {}.javaClass.getResource("/input")?.readText()?.trimIndent()
        ?: throw IllegalArgumentException("File not found")

    var validLines = 0
    var dampenedLines = 0

    input.lines().forEach { line ->
        val numbers = line.trim().split("\\s+".toRegex()).map { it.toInt() }
        if (isSafe(numbers)) {
            validLines++
        }
        if (isSafeDampened(numbers)) {
            dampenedLines++
        }
    }

    println("Number of safe lines: $validLines")
    println("Number of safe dampened lines: $dampenedLines")
}