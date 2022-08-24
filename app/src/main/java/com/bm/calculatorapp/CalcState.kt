package com.bm.calculatorapp

data class CalcState(
    val numb1 : String = "",
    val numb2 : String = "",
    val operation : CalcOperation? = null,
)
