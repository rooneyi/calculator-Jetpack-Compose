package com.example.calculatrice

sealed class UiEvent(
    val character:String?=null,
    val operator:CalculationOperator =CalculationOperator.NONE
) {
    object On0cliked : UiEvent(character = "0")
    object On1cliked : UiEvent(character = "1")
    object On2cliked : UiEvent(character = "2")
    object On3cliked : UiEvent(character = "3")
    object On4cliked : UiEvent(character = "4")
    object On5cliked : UiEvent(character = "5")
    object On6cliked : UiEvent(character = "6")
    object On7cliked : UiEvent(character = "7")
    object On8cliked : UiEvent(character = "8")
    object On9cliked : UiEvent(character = "9")

    object OnPLusCliked:UiEvent(operator = CalculationOperator.ADDITION)
    object OnMinusCliked:UiEvent(operator = CalculationOperator.SUBSTRACTION)
    object OnDivideCliked:UiEvent(operator = CalculationOperator.DIVISION)
    object OnMultiplicationCliked:UiEvent(operator = CalculationOperator.MULTIPLICATION)

    object OnClear : UiEvent()
    object OnClearAll : UiEvent()
    object OnEgal : UiEvent()

}