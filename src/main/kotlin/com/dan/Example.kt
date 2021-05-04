package com.dan

data class Person(val firstName: String, val lastName: String, val isIll: Boolean = false)

enum class Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    fun isWeekend(): Boolean = when (this) {
        SATURDAY, SUNDAY -> true
        else -> false
    }
}

enum class AtWorkState {
    AT_WORK,
    WEEKEND,
    ILLNESS
}


fun shouldWork(person: Person, day: Day): AtWorkState = when {
    person.isIll ->
        AtWorkState.ILLNESS
    day.isWeekend() ->
        AtWorkState.WEEKEND
    else ->
        AtWorkState.AT_WORK
}