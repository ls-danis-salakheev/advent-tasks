@file:JvmName("Main2")

package com.dan

import java.io.File

fun main() {

//    val input = readInput("src\\main\\resources\\kotlin.txt")
//    println(input)

    val persons = listOf(
        Person("Jack", "Miles"),
        Person("Peter", "Crosbey", isIll = true),
        Person("Mike", "Doe")
    )

//    persons.forEach{person -> println("$person is at work: ${shouldWork(person, Day.SUNDAY)}") }

    Day.values().forEach { day ->
        println("$day has been started")
        persons.forEach { person ->
            when(shouldWork(person, day)) {
                AtWorkState.AT_WORK -> println("$person at work")
                AtWorkState.ILLNESS -> println("$person ills")
                AtWorkState.WEEKEND -> println("$person having a rest")
            }
            println("$person at work: ${shouldWork(person, day)}") }
    }
}

private fun checkLine(lineNum: Int, input: Map<Coordinate, Int>, solution: Map<Coordinate, Int>): Boolean {

    for (i in 0 until 8) {
        val coordinate = Coordinate(lineNum, i)

        val checkedValue = input[coordinate]
            ?: solution[coordinate]
            ?: false
        var j = i + 1
        for (j in i + 1 until 9) {
            val internalCoordinate = Coordinate(lineNum, j)
            val internalValue = input[internalCoordinate]
                ?: solution[internalCoordinate]
                ?: false

            if (checkedValue != internalValue) {
                return false
            }
        }
    }
    return true
}


private fun readInput(path: String): Map<Coordinate, Int> =
    File(path)
        .readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val coorX = indexedValue.index
            indexedValue
                .value.toCharArray().withIndex()
                .filter { indexVal -> indexVal.value != '.' }
                .map { indexChar ->
                    val coorY = indexChar.index
                    val coordinate = Coordinate(coorX, coorY)
                    val number = Character.getNumericValue(indexChar.value)
                    coordinate to number
                }
        }
        .toMap()

private fun readInputByPairs(): Map<Pair<Int, Int>, Int> =
    File("src\\main\\resources\\kotlin.txt")
        .readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val coorX = indexedValue.index
            indexedValue.value.toCharArray().withIndex()
                .filter { indexedValue -> indexedValue.value != '.' }
                .map { indexChar ->
                    val coorY = indexChar.index
                    val number = Character.getNumericValue(indexChar.value)
                    (coorX to coorY) to number
                }
        }
        .toMap()


