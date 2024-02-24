package com.felipegandra.meuscontatos.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.felipegandra.meuscontatos.components.ContatoForm
import com.felipegandra.meuscontatos.components.ContatoList
import com.felipegandra.meuscontatos.components.Header
import com.felipegandra.meuscontatos.database.repository.ContatoRepository

@Composable
fun ContatosScreen()
{
    val nomeState = remember { mutableStateOf("") }
    val telefoneState = remember { mutableStateOf("") }
    val amigoState = remember { mutableStateOf(false) }

    val context = LocalContext.current
    val contatoRepository = ContatoRepository(context)

    var listaContatosState by remember { mutableStateOf(contatoRepository.listarContatos()) }
    val atualizarLista = { listaContatosState = contatoRepository.listarContatos() }

    val limparCampos = {
        nomeState.value = ""
        telefoneState.value = ""
        amigoState.value = false
    }

    Column(modifier = Modifier.background(Color.White) )
    {
        Header(text = "Meus Contatos")

        ContatoForm(
            nome = nomeState.value,
            telefone = telefoneState.value,
            amigo = amigoState.value,
            onNomeChange = { nomeState.value = it },
            onTelefoneChange = { telefoneState.value = it },
            onAmigoChange = { amigoState.value = it },
            atualizar = atualizarLista,
            limpar = limparCampos
        )

        ContatoList(
            listaContatosState,
            atualizarLista
        )
    }

}