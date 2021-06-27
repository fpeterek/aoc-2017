package org.fpeterek.aoc

import org.fpeterek.aoc.days.day1.Day1
import org.fpeterek.aoc.util.isOdd


fun parseArguments(arg1: String, arg2: String) =
    Arguments(arg1.trim().toInt(), arg2.trim())


fun getResult(args: Arguments) = when (args.day) {
    1 -> Day1(args.inFile).solve()
    else -> throw IllegalArgumentException("Invalid day ${args.day}")
}


fun runDay(args: Arguments) {
    val dayString = "------- Day ${args.day} -------"
    println(dayString)

    val (res1, res2) = getResult(args)
    println("Part 1: $res1")
    println("Part 2: $res2")

    println("-".repeat(dayString.length))
}

fun runDays(days: List<Arguments>) = days.forEach {
    try {
        runDay(it)
    } catch (e: Exception) {
        println(e.message)
        return
    }
}

fun parseDays(args: Array<String>) = (args.indices step 2).map {
    parseArguments(args[it], args[it + 1])
}

fun main(args: Array<String>) {
    if (args.size.isOdd) {
        println("Invalid arguments")
    }

    val days = try {
        parseDays(args)
    } catch (e: Exception) {
        println("Invalid arguments")
        return
    }

    runDays(days)
}
