package advent.ofcode.day3

import advent.ofcode.libs.ResourceLoader

// https://adventofcode.com/2024/day/4
fun exampleInput() = """
MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX
""".trimIndent()

val toSearch = "XMAS"

// Search rows and then inverted rows
// search columns and then inverted columns
// search diagonals and then inverted diagonals

// Find all the indexes of X and then try to find the rest from there
fun main() {
    println("Day 4: Ceres Search")

    val input = exampleInput()
//    val input = ResourceLoader.readLines("/day4input.txt")!!

    val grid = input.lines().map { it.toCharArray() }

    println(grid[0][2])
}