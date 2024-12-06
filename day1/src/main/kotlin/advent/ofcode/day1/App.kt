package advent.ofcode.day1

import java.io.File
import kotlin.math.abs

fun processInput(input: String): Pair<List<Int>, List<Int>> {
    val leftNumbers = mutableListOf<Int>()
    val rightNumbers = mutableListOf<Int>()

    input.trim().split("\n").forEach { line ->
        val numbers = line.trim().split("\\s+".toRegex()).map { it.toInt() }
        leftNumbers.add(numbers[0])
        rightNumbers.add(numbers[1])
    }

    return Pair(leftNumbers, rightNumbers)
}

fun calculateDifference(input: String): Int {
    val (leftNumbers, rightNumbers) = processInput(input)
    val sortedLeft = leftNumbers.sorted()
    val sortedRight = rightNumbers.sorted()

    return sortedLeft.zip(sortedRight).sumOf { (left, right) ->
        abs(left - right)
    }
}

fun findSimilarity(input: String): Int {
    val (leftNumbers, rightNumbers) = processInput(input)
    var similarityScore = 0

    leftNumbers.forEach { element ->
        val occurrences = rightNumbers.count { element == it }
        similarityScore += element * occurrences
    }

    return similarityScore
}

fun main() {
    val input = object {}.javaClass.getResource("/input")?.readText()
        ?: throw IllegalArgumentException("File not found")

    // Part 1
    val result1 = calculateDifference(input)
    println("Sum of differences: $result1")

    // Part 2
    val result2 = findSimilarity(input)
    println("Similarity score: $result2")
}
