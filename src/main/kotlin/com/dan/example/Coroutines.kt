package com.dan.example

import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class Coroutines {

    companion object {
        val random = Random(1)

        fun getNumber(): Int = nextInt()
    }

    infix fun inliner(int: Int): Int {

        return int + 1111;
    }
}


fun main() {

    println("Hello")

    when (getRandomly()) {
        in 0..99 -> println("99")
    }

    (0..55).toList()
        .filter { it == 10 || it == 15 }
//        .map { it.div(10) }
        .forEach { println(it) }

//    var i: Int = 0
//    for (i in 100 downTo 99) {
//        println("for")
//    }

    val listOf = mutableListOf(1, 4, 5, 6, 2, 1)

    listOf += 66

    val mSet = listOf
        .toMutableSet()
    mSet
        .removeAll(setOf(4, 66))

    mSet.forEach { println(it) }

    val coroutines = Coroutines()

    val i = coroutines inliner 66

    println(i)

    val ints = intArrayOf(10, 0, 99)

    ints[0] = 10000000

    ints.also { println(it.contentToString()) }

    val x = listOf(mutableListOf(1, 9))

    val map = mapOf(1 to "dan", 2 to "lil")

    println(map.getOrElse(11) { "NONE!" })

    map.plus(Pair(33, "DONE")).forEach { println(it) }

    val myList = listOf("1111" to 22, "dsfds" to 111)

    myList.forEach { println(it) }

    val aPair = 111 to "dan"

    val player = Player()
    println(player.name?.let { println(it.length) })

    println("hello".capitalize(Locale.GERMAN))
}

fun getRandomly(): Int = run {
    nextInt()
}

class Player {
    var name: String? = null
        get() = field
        private set(value) {
            field = value?.trim()
        }
}







