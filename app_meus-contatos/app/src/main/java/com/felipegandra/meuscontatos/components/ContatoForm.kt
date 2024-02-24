package com.felipegandra.meuscontatos.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.felipegandra.meuscontatos.database.repository.ContatoRepository
import com.felipegandra.meuscontatos.model.Contato

@Composable
fun ContatoForm(
    nome: String,
    telefone: String,
    amigo: Boolean,
    onNomeChange: (String) -> Unit,
    onTelefoneChange: (String) -> Unit,
    onAmigoChange: (Boolean) -> Unit,
    atualizar: () -> Unit,
    limpar: () -> Unit
) {
    val context = LocalContext.current
    val contatoRepository = ContatoRepository(context)

    Card(
        modifier = Modifier
            .zIndex(2f)
            .padding(horizontal = 24.dp)
            .offset(y = (-30).dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    )
    {
        Column(modifier = Modifier.padding(32.dp))
        {
            InputField(
                value = nome,
                label = "Nome do contato",
                capitalization = KeyboardCapitalization.Words,
                onChange = { onNomeChange(it) }
            )

            InputField(
                value = telefone,
                label = "Telefone do contato",
                keyboard = KeyboardType.Phone,
                onChange = { onTelefoneChange(it) }
            )

            CheckBoxItem(
                text = "Amigo",
                checked = amigo,
                onAmigoChange = { onAmigoChange(it) }
            )

            ButtonPost(
                text = "CADASTRAR",
                onclick = {
                    val contato = Contato(id = 0, nome = nome, telefone = telefone, isAmigo = amigo)
                    contatoRepository.salvar(contato)
                    atualizar()
                    limpar()
                }
            )

        }
    }
}