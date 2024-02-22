package com.felipegandra.calculodejuros.juros

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.felipegandra.calculodejuros.components.CardResult
import com.felipegandra.calculodejuros.components.InputTextField
import com.felipegandra.calculodejuros.components.SubTitleText
import com.felipegandra.calculodejuros.components.TitleText

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")
    val taxa by jurosScreenViewModel.taxa.observeAsState(initial = "")
    val tempo by jurosScreenViewModel.tempo.observeAsState(initial = "")
    val juros by jurosScreenViewModel.juros.observeAsState(initial = 0.0)
    val montante by jurosScreenViewModel.montante.observeAsState(initial = 0.0)

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
                        updateValue = { jurosScreenViewModel.onCapitalChanged(it) }
                    )

                    InputTextField(
                        label = "Taxa de juros mensal",
                        placeHolder = "Qual a taxa de juros mensal?",
                        value = taxa,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier,
                        updateValue = { jurosScreenViewModel.onTaxaChanged(it) }
                    )

                    InputTextField(
                        label = "Período em meses",
                        placeHolder = "Qual o tempo em meses?",
                        value = tempo,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier,
                        updateValue = { jurosScreenViewModel.onTempoChanged(it) }
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp, bottom = 16.dp),
                        onClick = {
                            jurosScreenViewModel.calcularJurosViewModel()
                            jurosScreenViewModel.calcularMontanteViewModel()
                        }
                    ) {
                        Text(text = "CALCULAR")
                    }

                }

            }

            CardResult(juros = juros, montante = montante )

        }

    }
}