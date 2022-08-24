package com.bm.calculatorapp

sealed class CalcOperation(val symbol: String) {
    object Add : CalcOperation("+")
    object Subtract : CalcOperation("-")
    object Multiply : CalcOperation("*")
    object Divide : CalcOperation("/")
    object Equals : CalcOperation("=")

}
