package com.felipegandra.meuscontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.felipegandra.meuscontatos.database.repository.ContatoRepository
import com.felipegandra.meuscontatos.model.Contato
import com.felipegandra.meuscontatos.ui.theme.IndieFlower
import com.felipegandra.meuscontatos.ui.theme.MeusContatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeusContatosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ContatosScreen()
                    }
                }
            }
        }
    }
}




@Composable
fun ContatosScreen() {

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


    Column(modifier = Modifier.background(Color.White) ) {
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

        ContatoList(listaContatosState, atualizarLista)
    }

}



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

    Column(modifier = Modifier
        .background(color = Color(0xFF651f71))
        .fillMaxWidth()
        .height(150.dp)
    )
    {
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            text = "Meus Contatos",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = IndieFlower,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center
        )
    }

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
        Column(
            modifier = Modifier
                .padding(32.dp)
        )
        {
            OutlinedTextField(
                value = nome,
                onValueChange = { onNomeChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = { Text(text = "Nome do contato") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Words
                )
            )

            OutlinedTextField(
                value = telefone,
                onValueChange = { onTelefoneChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = { Text(text = "Telefone do contato") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Checkbox(checked = amigo, onCheckedChange = {
                    onAmigoChange(it)
                })
                Text(text = "Amigo")
            }

            Button(
                onClick = {
                    val contato = Contato(id = 0, nome = nome, telefone = telefone, isAmigo = amigo)
                    contatoRepository.salvar(contato)
                    atualizar()
                    limpar()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "CADASTAR",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}



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
            ContatoCard(contato, atualizar)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}



@Composable
fun ContatoCard(contato: Contato, atualizar: () -> Unit) {
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