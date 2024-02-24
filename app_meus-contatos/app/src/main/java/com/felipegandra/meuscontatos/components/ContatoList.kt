package com.felipegandra.meuscontatos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.felipegandra.meuscontatos.model.Contato

@Composable
fun ContatoList(listaContatos: List<Contato>, atualizar: () -> Unit) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .offset(y = (-40).dp)
        .padding(horizontal = 24.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        for (contato in listaContatos){
            ContatoItem(contato, atualizar)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}