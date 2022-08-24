package com.bm.calculatorapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {
    var state by mutableStateOf(CalcState())
        private set

    fun onAction(action: CalcAction){
        when(action){
            is CalcAction.Number -> enterNumber(action.number)
            is CalcAction.Decimal -> enterDecimal()
            is CalcAction.Clear -> state = CalcState()
            is CalcAction.Operation -> enterOperation(action.operation)
            is CalcAction.Equals -> calculate()
            is CalcAction.Delete -> performDelete()
        }
    }

    private fun calculate() {
        val numb1 = state.numb1.toDoubleOrNull()
        val numb2 = state.numb2.toDoubleOrNull()
        if(numb1 != null && numb2 != null){
            val result = when(state.operation){
                is CalcOperation.Add -> numb1.plus(numb2)
                is CalcOperation.Subtract -> numb1.minus(numb2)
                is CalcOperation.Multiply -> numb1.times(numb2)
                is CalcOperation.Divide -> numb1.div(numb2)
                null -> return
                else -> {
                    return
                }
            }
            state = state.copy(
                numb1 = result.toString().take(15),
                numb2 = "",
                operation = null
            )
        }
    }

    private fun performDelete() {
        when {
            state.numb2.isNotBlank() -> state = state.copy(
                numb2 = state.numb2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.numb1.isNotBlank() -> state = state.copy(
                numb1 = state.numb1.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: CalcOperation) {
        if(state.numb1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.numb1.contains(".") && state.numb1.isNotBlank()){
            state = state.copy(numb1 = state.numb1 + ".")
            return
        }
        if(!state.numb2.contains(".") && state.numb2.isNotBlank()){
            state = state.copy(numb2 = state.numb2 + ".")
        }

    }

    private fun enterNumber(number: Int) {
        if(state.operation == null){
            if(state.numb1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(numb1 = state.numb1 + number)
            return
        }
        if(state.numb2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(numb2 = state.numb2 + number)
    }

    companion object {
        const val MAX_NUM_LENGTH = 8
    }
}