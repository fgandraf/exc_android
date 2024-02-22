package com.felipegandra.calculodejuros.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.felipegandra.calculodejuros.components.ButtonCalculate
import com.felipegandra.calculodejuros.components.CardResult
import com.felipegandra.calculodejuros.components.InputTextField
import com.felipegandra.calculodejuros.components.SubTitleText
import com.felipegandra.calculodejuros.components.TitleText

@Composable
fun JurosScreen() {
    var capital by remember { mutableStateOf("") }
    var taxa by remember { mutableStateOf("") }
    var tempo by remember { mutableStateOf("") }
    var juros by remember { mutableDoubleStateOf(0.0) }
    var montante by remember { mutableDoubleStateOf(0.0) }

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            TitleText(title = "Cálculo de Juros Simples")

            Card(modifier = Modifier.fillMaxWidth()) {

                Column(modifier = Modifier.padding(16.dp)) {

                    SubTitleText("Dados do Investimento")

                    InputTextField(
                        label = "Valor do investimento",
                        placeHolder = "Quanto deseja investir?",
                        value = capital,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier,
                        updateValue = { capital = it }
                    )

                    InputTextField(
                        label = "Taxa de juros mensal",
                        placeHolder = "Qual a taxa de juros mensal?",
                        value = taxa,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier,
                        updateValue = { taxa = it }
                    )

                    InputTextField(
                        label = "Período em meses",
                        placeHolder = "Qual o tempo em meses?",
                        value = tempo,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier,
                        updateValue = { tempo = it }
                    )

                    ButtonCalculate(
                        capital = capital, taxa = taxa, tempo = tempo,
                        response = {
                            juros = it.first
                            montante = it.second
                        }
                    )

                }

            }

            CardResult(juros = juros, montante = montante )

        }

    }
}