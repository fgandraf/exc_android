package com.felipegandra.meuscontatos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.meuscontatos.database.repository.ContatoRepository
import com.felipegandra.meuscontatos.model.Contato

@Composable
fun ContatoItem(contato: Contato, atualizar: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = CutCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        val context = LocalContext.current
        val contatoRepository = ContatoRepository(context)

        Spacer(modifier = Modifier
            .height(2.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(2f)) {
                Text(
                    text = contato.nome,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = contato.telefone,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = if (contato.isAmigo) "Amigo" else "Contato",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            IconButton(onClick = {
                contatoRepository.excluir(contato)
                atualizar()
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
        }


    }
}