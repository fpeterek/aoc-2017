package org.fpeterek.aoc.days.day2

import org.fpeterek.aoc.Day
import org.fpeterek.aoc.Result
import org.fpeterek.aoc.util.divisibleBy
import org.fpeterek.aoc.util.ordered


class Day2(inputFile: String) : Day(inputFile) {

    private val spreadsheet = input
        .filter { it.isNotBlank() }
        .map { line ->
            line.split("\\s".toRegex())
                .filter { it.isNotBlank() }
                .map { it.toLong() }
        }

    private fun findDivisibleNumbers(list: List<Long>): Pair<Long, Long> {
        for (i in 0 until list.lastIndex) {
            for (j in (i+1)..list.lastIndex) {
                val (lower, higher) = ordered(list[i], list[j])
                if (higher divisibleBy lower) {
                    return higher to lower
                }
            }
        }

        throw RuntimeException("Invalid input")
    }

    private fun part1(): Long = spreadsheet.sumOf { it.maxOrNull()!! - it.minOrNull()!! }

    private fun part2(): Long = spreadsheet
        .map { findDivisibleNumbers(it) }
        .sumOf { (l, r) -> l / r }

    override fun solve() = Result(part1(), part2())
}
