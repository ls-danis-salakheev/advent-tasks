package com.dan.example

import java.time.LocalDate
import java.util.*

class Weapon(val name: String)

class Player1 {
    var weapon: Weapon? = Weapon("Ebony Kris")

    fun printWeaponName() {
        weapon?.name.also { println(it) }
    }
}

fun main(args: Array<String>) {
    Player1().printWeaponName()

    val team = Team(name = "Avangard", city = "Omsk", 16)
    val team2 = Team("Kazan")


    team.city = "Moscow"

    println(team)
//    println(team2.arena)

    val i = 100
    println(i.times(3))

    val sword = Sword("DANIS")
//    sword.name = "Ilnur"

    println(sword.name)

//    val scanner = Scanner(System.`in`)
//    println(scanner.nextInt())

    val room = Room("Hall")
    println(room.description())
    println(room.load())
}

data class Team(val name: String, var city: String, var points: Int?) {

    private val age = 0

    lateinit var arena: String

    val est: LocalDate by lazy {
        LocalDate.of(1954, 10, 6)
    }

    constructor(city: String) : this("Ak Bars", city, 0)
}

class Sword(_name: String) {
    var name = _name
        get() = "Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }

    init {
        name = _name
    }
}

open class Room(val name: String) {

    fun description() = "This is room - $name"

    open fun load() = "Nothing"
}

class TownSquare() : Room("Square") {

    override fun load(): String {
        return super.load()
    }
}