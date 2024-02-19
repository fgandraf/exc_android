package com.felipegandra.components

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.components.ui.theme.ComponentsTheme
import com.felipegandra.components.ui.theme.Kablamo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Greatings()
                }
            }
        }
    }
}

@Composable
fun Greatings() {
    Column(
        modifier = Modifier
            .background(Color(0xFF212121))
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    )
    {
        Header()
        TextWithBorder()
        ExternalFont()
        TextField()
        NumberField()
        EmailField()
    }
}

@Preview
@Composable
fun GreatingsPrev() {
    Greatings()
}




@Composable
fun Header() {
    Column(modifier = Modifier
        .padding(bottom = 50.dp)
        .fillMaxWidth()) {
        Text(
            text = "FIAP",
            fontSize = 32.sp,
            color = Color(0xFFED145B),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Estudando programação Android",
            color = Color(180,180,180),
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Cursive,
            fontSize = 22.sp
        )
    }
}

@Composable
fun TextWithBorder() {
    Column(modifier = Modifier
        .padding(bottom = 50.dp)
        .fillMaxWidth()) {
        Text(
            modifier = Modifier
                .background(Color(90, 88, 126, 255))
                .border(border = BorderStroke(2.dp, color = Color.Gray))
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .align(Alignment.CenterHorizontally),
            text = "Estudando programação Android",
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )
    }
}

@Composable
fun ExternalFont() {
    Column(modifier = Modifier
        .padding(bottom = 50.dp)
        .fillMaxWidth()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Utilizando fonte externa",
            color = Color(180,180,180),
            fontWeight = FontWeight.Light,
            fontFamily = Kablamo,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TextField() {
    var nome by remember{ mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = nome,
            onValueChange = { nome = it },
            label = { Text(text = "Qual é o seu nome?") },
            placeholder = { Text(text = "Digite seu nome completo") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.person_24),
                    contentDescription = "ícone de configuração"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.notes_24),
                    contentDescription = "ícone de configuração"
                )
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        )
    }
}

@Composable
fun NumberField() {
    var idade by remember{ mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            value = idade,
            onValueChange = { idade = it },
            label = { Text(text = "Qual a sua idade?") },
            placeholder = { Text(text = "Digite um número") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "ícone de configuração"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.notes_24),
                    contentDescription = "ícone de configuração"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
                //color = Color.Red,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Gray,
                cursorColor = Color.Yellow
            )
        )
    }
}

@Composable
fun EmailField() {
    var email by remember{ mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Qual o seu email?") },
            placeholder = { Text(text = "Digite o email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "ícone de configuração"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.notes_24),
                    contentDescription = "ícone de configuração"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }
}







// Color(0xFFAB1212) -> Exadecimal 0x + Opacidade FF + AB1212

// padding(16.dp) -> todos os lados
// padding(horizontal = 32.dp) -> apenas no left e no right
// padding(vertical = 32.dp) -> apenas no top e no botton
// padding(horizontal = 20.dp, vertical = 32.dp) -> vertical e horizontal
// .padding(top = 16.dp, end = 10.dp, bottom = 10.dp, start = 12.dp) -> controles independentes

// Incluir fonte: Criar a pasta font dentro de res, criar a variável dentro de ui.theme/Type | val Kablamo = FontFamily(Font(R.font.kablammo_regular))

// Em expressões Lambda, por exemplo:
// onValueChange = { texto = it }
// it é o nome automático da variável da função porém é possível nomea-la:
// onValueChange = { x -> texto = x }
// Não é necessário texto += x pois a variável texto é do tipo remember
