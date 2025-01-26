package advent.ofcode.day3

import advent.ofcode.libs.ResourceLoader

// https://adventofcode.com/2024/day/3
fun exampleInput() = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
fun part2Example() = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

val patten = "mul\\((\\d+),(\\d+)\\)".toRegex()
val numPatten = "(\\d+)".toRegex()

val patternPt2 = """mul\((\d+),(\d+)\)|do(n't)?\(\)""".toRegex()

fun mul(input: String) = numPatten.findAll(input).toList().fold(1L) { acc, num ->
    acc * num.value.toLong()
}


fun part1(input: String): Long {
    return patten.findAll(input).fold(0) { sum, mul ->
        sum + mul(mul.value)
    }
}

fun part2(input: String): Long {
    var enabled = true

    return patternPt2.findAll(input).fold(0) { sum, it ->
        sum + when (it.value) {
            "do()" -> {
                enabled = true
                0
            }
            "don't()" -> {
                enabled = false
                0
            }
            else -> {
                if (enabled) mul(it.value) else 0
            }
        }
    }
}

// Need to count how many reports considerd as safe
fun main() {
    println("Day 3: Red-Nosed Reports")

    val input = ResourceLoader.readLinesAsString("/day3input.txt")!!

    println("sum part1: ${part1(input)}")
    println("sum part2: ${part2(input)}")

}