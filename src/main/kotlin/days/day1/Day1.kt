package org.fpeterek.aoc.days.day1

import org.fpeterek.aoc.Day
import org.fpeterek.aoc.Result


private typealias IndexProvider = (Int, String) -> Int


class Day1(inputFile: String) : Day(inputFile) {

    private fun calc(indexProvider: IndexProvider) = input[0].trim().let { str ->
        str.indices.map { index ->
            when (str[index] == str[indexProvider(index, str)]) {
                true -> str[index].digitToInt().toLong()
                else -> 0L
            }
        }
    }.sum()

    override fun solve(): Result = Result(
        calc { idx, str -> (idx+1) % str.length },
        calc { idx, str -> (idx+str.length/2) % str.length }
    )

}

