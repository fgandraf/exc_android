package com.felipegandra.calculadoraimc

import androidx.compose.ui.graphics.Color
import kotlin.math.pow

fun calcularImc(peso : Double, altura : Double) : Double{
    return peso / (altura / 100).pow(2)
}

fun obterStatusImc(imc : Double) : Pair<String, Color> {
    return if(imc < 18.5) {
        Pair("Abaixo do peso", Color.Red)
    } else if (imc >= 18.5 && imc < 25.0) {
        Pair("Peso Ideal", Color(0xFF008000))
    } else if (imc >= 25.0 && imc < 30.0) {
        Pair("Levemente acima do peso", Color(0xFFFF6400))
    } else if (imc >= 30.0 && imc < 35.0) {
        Pair("Obesidade Grau I", Color.Red)
    } else if (imc >= 35.0 && imc < 40.0) {
        Pair("Obesidade Grau II", Color.Red)
    } else {
        Pair("Obesidade Grau III", Color.Red)
    }
}