package advent.ofcode.day1

import advent.ofcode.libs.ResourceLoader
import kotlin.math.abs

// https://adventofcode.com/2024/day/1

fun exampleLists() =
    listOf(3, 4, 2, 1, 3, 3) to
    listOf(4, 3, 5, 3, 9, 3)

fun inputLists(path: String): Pair<List<Int>, List<Int>> {
    val lines = ResourceLoader.loadResource(path)?.readText()?.lines()
        ?: throw Exception("Could not load resource $path")

    val column1 = mutableListOf<Int>()
    val column2 = mutableListOf<Int>()

    lines.forEach { str ->
        val (a, b) = str.split("\\s+".toRegex()).map { it.toInt() }
        column1.add(a)
        column2.add(b)
    }

    return column1 to column2
}

// First lets sort the lists O(n log n)
// and then lets fold them and calculate the distance between each two elements
// and some the result
fun solvePart1(list1: List<Int>, list2: List<Int>): Int {
    return list1.zip(list2).fold(0) { acc, (a, b) -> acc + abs(a - b) }
}

fun solvePart2(list1: List<Int>, list2: List<Int>): Int {
    return list1.fold(0) { acc, x ->
        acc + (list2.count { it == x } * x)
    }
}

fun main() {
//    val data = exampleLists()
    val data = inputLists("/input.txt")
    val firstSorted = data.first.sorted()
    val secondSorted = data.second.sorted()
    println(solvePart1(firstSorted, secondSorted))

    println(solvePart2(firstSorted, secondSorted))
}
