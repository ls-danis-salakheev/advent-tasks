package com.dan.example

open class Food

class VeganFood : Food()

interface Seller<out T> {

    fun <T> generify(value: T): String where T : String {

        return String("hello".toByteArray())
    }
}

class FoodSeller : Seller<Food>

class VeganFoodSeller : Seller<VeganFood>

interface Consumer<in T>

class Person : Consumer<Food>

class Vegan : Consumer<VeganFood>

fun main() {
    var foodSeller: Seller<Food>

    foodSeller = FoodSeller()
    foodSeller = VeganFoodSeller()

    var veganConsumer: Consumer<VeganFood>

    veganConsumer = Vegan()
    veganConsumer = Person()

    val genList: List<Int> = listOf(1, 2, 3, 5, 6, 9, 4);

    val anyList: List<Any> = genList


}


fun stars(value: Consumer<*>): String = "stars"


abstract class MyClass {

    abstract fun getU()

    fun getE(): Int = (0..5).random()
}

class Ing<E>(val name: E) {

}