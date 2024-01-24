package com.example.calculatrice

data class UiState(
    val calculationExpression:String = "",
    val firstNumber:String ="0",
    val secondNumber:String = "0",
    val currentOprator:CalculationOperator = CalculationOperator.NONE,
    val answer:String = ""
)
