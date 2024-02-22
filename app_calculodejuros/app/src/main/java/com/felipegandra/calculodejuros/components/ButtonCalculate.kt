package com.felipegandra.calculodejuros.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.felipegandra.calculodejuros.calculos.calcularJuros
import com.felipegandra.calculodejuros.calculos.calcularMontante

@Composable
fun ButtonCalculate(
    capital: String,
    taxa: String,
    tempo: String,
    response : (Pair<Double, Double>) -> Unit
) {

    var juros : Double
    var montante : Double

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp),
        onClick = {
            juros = calcularJuros(
                capital = capital.toDouble(),
                taxa = taxa.toDouble(),
                tempo = tempo.toDouble()
            )
            montante = calcularMontante(
                capital = capital.toDouble(),
                juros = juros
            )
            response(Pair(juros, montante))
        }
    ) {
        Text(text = "CALCULAR")
    }





}