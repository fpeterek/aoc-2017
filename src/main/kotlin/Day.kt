package org.fpeterek.aoc

import org.fpeterek.aoc.util.loadAsFile

abstract class Day(private val inputFile: String) {

    protected val input = inputFile.loadAsFile()

    abstract fun solve(): Result
}
