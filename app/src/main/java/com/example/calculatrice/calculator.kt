package com.example.calculatrice

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel


@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = vie){
    val uiState  = viewModel.uiState

    Column(modifier = Modifier.fillMaxSize()) {

    Box(modifier = Modifier
        .weight(2f)
        .fillMaxWidth()) {
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom){

            Row(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {
                Text(text = uiState.value.calculationExpression,
                    fontSize = 30.sp)
            }
            Row (modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.End){
                Text(text = if (uiState.value.answer.isNotEmpty())
                    DecimalFormat("###.#").format(uiState.value.answer.toDouble())
                    else if (uiState.value.currentOprator == CalculationOperator.NONE)
                    DecimalFormat("###.#").format(uiState.value.firstNumber.toDouble())
                    else DecimalFormat("###.#").format(uiState.value.secondNumber)
                                                                                      ,
                    fontSize = 50.sp,
                    color = Color.Gray
                )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)){
            Row (modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically){
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "CA",
                    isHighlight = true,
                    onActionCalculatorButton = {})
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "/",
                    isHighlight = true,
                    onActionCalculatorButton = {})
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "X",
                    isHighlight = true,
                    onActionCalculatorButton = {})
                CalculatorAction (modifier = Modifier.weight(1f),
                    icon = Icons.Default.ArrowBack,
                    isHighlight = true,
                    onActionCalculatorButton = {})
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically){
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "7",
                    onActionCalculatorButton = {
                        viewModel.OnUiEvent(UiEvent.On7cliked)
                    })
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "8",
                    onActionCalculatorButton = {
                        viewModel.OnUiEvent(UiEvent.On8cliked)
                    })
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "9",
                    onActionCalculatorButton = {
                        viewModel.OnUiEvent(UiEvent.On9cliked)
                    })
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "-",
                    isHighlight = true,
                    onActionCalculatorButton = {})
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically){
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "6",
                    onActionCalculatorButton = {
                        viewModel.OnUiEvent(UiEvent.On6cliked)
                    })
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "5",
                    onActionCalculatorButton = {
                        viewModel.OnUiEvent(UiEvent.On5cliked)
                    })
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "4",
                    onActionCalculatorButton = {viewModel.OnUiEvent(UiEvent.On4cliked)})
                CalculatorAction (modifier = Modifier.weight(1f),
                    character = "+",
                    isHighlight = true,
                    onActionCalculatorButton = {})
            }
            Row (modifier = Modifier
                .weight(2f)
                .fillMaxWidth() ){
                Column(modifier = Modifier.weight(3f)
                    ) {
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically){
                        CalculatorAction (modifier = Modifier.weight(1f),
                            character = "1",
                            onActionCalculatorButton = {
                                viewModel.OnUiEvent(UiEvent.On1cliked)
                            })
                        CalculatorAction (modifier = Modifier.weight(1f),
                            character = "2",
                            onActionCalculatorButton = {
                                viewModel.OnUiEvent(UiEvent.On2cliked)
                            })
                        CalculatorAction (modifier = Modifier.weight(1f),
                            character = "3",
                            onActionCalculatorButton = {
                                viewModel.OnUiEvent(UiEvent.On3cliked)
                            })

                    }
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically){
                        CalculatorAction (modifier = Modifier.weight(1f),
                            character = "0",
                            onActionCalculatorButton = {
                                viewModel.OnUiEvent(UiEvent.On0cliked)
                            })


                    }

                }
                Box (modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()){
                    Box (modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .width(60.dp)
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .align(alignment = Alignment.Center)
                        .clickable {
                            //action a ajouter lors du clic
                        }){
                        Text(text = "=",
                            style = TextStyle(fontSize = 30.sp, color = Color.White),
                            modifier = Modifier.align(Alignment.Center)

                        )

                    }

                }

            }
        }
    }
}
@Composable
fun CalculatorAction(
    modifier: Modifier = Modifier,
    character :String? = null,
    icon: ImageVector? = null,
    isHighlight:Boolean?=false,
    onActionCalculatorButton:() -> Unit
){
    Box (modifier = modifier
        .size(60.dp)
        .clip(RoundedCornerShape(50.dp))
        .clickable { onActionCalculatorButton() }){
        if (icon != null){
            Icon(imageVector = icon, contentDescription ="icon a afficher",
                tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(alignment = Alignment.Center))
        }else{
            Text(text = character!!,
                style = TextStyle(
                    fontSize = 30.sp,
                    color = if (isHighlight == true) MaterialTheme.colorScheme.secondary else Color.Black
                ),
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun CalculatorScrennPreview(){
    CalculatorScreen(viewModel = CalculatorViewModel())
}