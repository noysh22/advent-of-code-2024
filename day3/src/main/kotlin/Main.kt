package advent.ofcode.day3

import advent.ofcode.libs.ResourceLoader
import advent.ofcode.libs.removeAt
import kotlin.math.abs

// https://adventofcode.com/2024/day/3
fun exampleInput() = """
        37 36 39 38 37 34
        67 70 72 74 79
        90 91 93 96 93
        8 6 4 4 1
        7 6 4 2 1
        1 2 7 8 9
        9 7 6 2 1
        1 3 2 4 5
        1 3 6 7 9
    """.trimIndent().lines().map { line ->
        line.split(" ").map { it.toInt() }
    }

// Need to count how many reports considerd as safe
fun main() {
    println("Day 3: Red-Nosed Reports")

}