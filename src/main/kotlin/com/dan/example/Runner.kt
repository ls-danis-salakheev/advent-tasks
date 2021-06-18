package com.dan.example

import java.util.*
import java.util.stream.Collectors

fun main() {

    val retailer: Retailer<Pet> = CatRetailer()
    println(retailer.sell())

    val catList = listOf<Cat>(
        Cat("Tom"),
        Cat("Jack"),
        Cat("Alex"),
        Cat("Alex"),
        Cat("Mickie"),
        Cat("Dave"),
        Cat("Pit"),
        Cat("Eric")
    )

    catList
        .stream()
        .filter { it.name.equals("Tom") || it.name.equals("Alex") }
        .collect(Collectors.toList())
//        .sortBy { Comparator.naturalOrder<Cat>() }
        .forEach { println(it) }

    val pow = { x: Int -> x + 5 }
    val pow2 = { x: Int, y: Int -> x + y + 5 }
    pow(2).also { println(it) }

    println(pow(100))

    val greeting: () -> String = { "hey-hey" }

    val addFive: (Int) -> Int = { it + 5 }

    println(addFive(66))

    val calculation: (Double, Double) -> Double = { a, b -> b + a }

    val print: (Int, Int) -> Unit = { a, b -> println(a + b) }

    println(calculation(2.3, 1.9))

    print(2, 5)
    
}

inline fun printer(any: Any?) {
    println(any.toString())
}

abstract class Pet(val name: String) {

    abstract fun doSmth()

    override fun toString(): String {
        return "Pet(name='$name')"
    }
}

class Cat(name: String) : Pet(name) {

    override fun doSmth() = println("meow")

}

class Dog(name: String) : Pet(name) {

    override fun doSmth() = println("gav-gav")
}

interface Retailer<out T> {

    val pets: Collection<T>

    fun sell(): T
}

class CatRetailer : Retailer<Cat> {

    override val pets: List<Cat> = listOf(
        Cat("Acat"),
        Cat("Bcat"),
        Cat("Ccat"),
        Cat("Dcat"),
        Cat("Ecat")
    )

    override fun sell(): Cat = pets.random()
}

class DogRetailer : Retailer<Dog> {

    override val pets: List<Dog> = listOf(
        Dog("Adog"),
        Dog("Bdog"),
        Dog("Cdog"),
        Dog("Ddog"),
        Dog("Edog")
    )

    override fun sell(): Dog = pets.random()
}

