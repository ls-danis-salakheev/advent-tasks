package com.dan

data class Coordinate(val X: Int, val Y: Int) {

    override fun toString(): String =
        "($X, $Y)"
}
