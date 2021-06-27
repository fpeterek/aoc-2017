package org.fpeterek.aoc.util

import java.io.File

val Int.isOdd
    get() = this % 2 == 1

val Int.isEven
    get() = this % 2 == 0

infix fun Long.divisibleBy(num: Long) = this % num == 0L

fun loadFile(filename: String) = File(filename).readLines()

fun String.loadAsFile() = loadFile(this)
