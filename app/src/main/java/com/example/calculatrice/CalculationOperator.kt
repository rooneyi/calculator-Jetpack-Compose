package com.example.calculatrice

enum class CalculationOperator(val symbol:String? = null) {
    NONE,
    ADDITION("+"),
    SUBSTRACTION("-"),
    MULTIPLICATION("X"),
    DIVISION("/")
}