package advent.ofcode.day2

import advent.ofcode.libs.ResourceLoader
import advent.ofcode.libs.removeAt
import kotlin.math.abs

// https://adventofcode.com/2024/day/2
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

fun List<Int>.isSafe(): Boolean {
    val differences = this.zipWithNext { a, b -> a - b }
    return differences.all { it in -3..3 } && // make sure diff is max 3
        (differences.all { it > 0 } || differences.all { it < 0 }) // make sure everything is increasing or decreasing
}

fun List<Int>.isSafeDampended(): Boolean {
    if (this.isSafe()) return true

    return this.indices.any { idx ->
        val skipped = this.removeAt(idx)
        skipped.isSafe()
    }
}
fun printMark(isSafe: Boolean) = if (isSafe) "✅" else "❌"

// Need to count how many reports considerd as safe
fun main() {
    println("Day 2: Red-Nosed Reports")

//    val data = exampleInput()

    val data = ResourceLoader.loadResource("/day2Input.txt")
        ?.readText()?.lines()?.map { line ->
            line.split(" ").map { it.toInt()
        }
    } ?: throw Exception("Could not load resource /day2Input.txt")

    println(data.size)

    data.forEach {
        println("${it.joinToString(" ")} - ${printMark(it.isSafeDampended())}")
    }

    println(data.count { it.isSafe() })
    println(data.count { it.isSafeDampended() })
}