package com.example.calculatrice

import android.icu.text.DecimalFormat
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class CalculatorViewModel:ViewModel() {
    val uiState:MutableState<UiState> = mutableStateOf(UiState())

    fun OnUiEvent(uiEvent: UiEvent){
            when (uiEvent){
                is UiEvent.On0cliked,UiEvent.On1cliked,UiEvent.On2cliked,UiEvent.On3cliked,
                    UiEvent.On4cliked,UiEvent.On5cliked,UiEvent.On6cliked,UiEvent.On7cliked,UiEvent.On8cliked,
                    UiEvent.On9cliked ->{
                        updateNumber(uiEvent.character!!)

                    }else ->{}
            }
    }
    private fun updateNumber(numberCharacter:String){
        if (uiState.value.currentOprator == CalculationOperator.NONE) {
            uiState.value = uiState.value.copy(
                firstNumber = uiState.value.firstNumber + numberCharacter
            ) }else{
                uiState.value = uiState.value.copy(
                    calculationExpression = "${myDecimal(uiState.value.firstNumber.toDouble())} ${uiState.value.currentOprator.symbol}",
                    secondNumber = uiState.value.secondNumber + numberCharacter
                )
            }
        }
    private fun myDecimal(input : Double) : String =DecimalFormat("###.#").format(input)
    }
