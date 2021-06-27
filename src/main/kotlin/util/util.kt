package org.fpeterek.aoc.util

import java.io.File

val Int.isOdd
    get() = this % 2 == 1

val Int.isEven
    get() = this % 2 == 0

fun loadFile(filename: String) = File(filename).readLines()

fun String.loadAsFile() = loadFile(this)
