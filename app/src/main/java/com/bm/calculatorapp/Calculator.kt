package com.bm.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalcState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalcAction) -> Unit
){
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.numb1 + (state.operation?.symbol ?: "") + state.numb2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = MaterialTheme.colors.onSurface,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButton(symbol = "AC",
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalcAction.Clear)
                    }
                )
                CalcButton(symbol = "Del",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Delete)
                    }
                )
                CalcButton(symbol = "÷",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Operation(CalcOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButton(symbol = "7",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(7))
                    }
                )
                CalcButton(symbol = "8",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(8))
                    }
                )
                CalcButton(symbol = "9",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(9))
                    }
                )
                CalcButton(symbol = "×",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Operation(CalcOperation.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButton(symbol = "4",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(4))
                    }
                )
                CalcButton(symbol = "5",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(5))
                    }
                )
                CalcButton(symbol = "6",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(6))
                    }
                )
                CalcButton(symbol = "-",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Operation(CalcOperation.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButton(symbol = "1",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(1))
                    }
                )
                CalcButton(symbol = "2",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(2))
                    }
                )
                CalcButton(symbol = "3",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Number(3))
                    }
                )
                CalcButton(symbol = "+",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Operation(CalcOperation.Add))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButton(symbol = "0",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalcAction.Number(0))
                    }
                )
                CalcButton(symbol = ".",
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Decimal)
                    }
                )
                CalcButton(symbol = "=",
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Equals)
                    }
                )
            }
        }
    }
}