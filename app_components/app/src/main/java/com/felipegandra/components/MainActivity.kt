package com.felipegandra.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.graphics.RectangleShape
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
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
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
    )
    {
        Header()
        TextWithBorder()
        ExternalFont()
        TextField()
        NumberField()
        EmailField()
        OutlinedTF()
        CheckB()
        Radio()
        Botao()
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
            modifier = Modifier.padding(bottom = 14.dp),
            text = "Lets rock the future!",
            color = Color(180,180,180),
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp
        )
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .border(
                    BorderStroke(2.dp, Color(0xFFED145B)),
                    shape = RectangleShape)
                .fillMaxWidth()
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
            fontFamily = FontFamily.Cursive,
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

@Composable
fun OutlinedTF() {

    var email by remember{ mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 32.dp, bottom = 50.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it},
            singleLine = true,
            label = { Text(text = "Qual o seu email") },
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray,
                unfocusedTextColor = Color.Gray
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    tint = Color.Gray,
                    contentDescription = "ícone de configuração"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }
}

@Composable
fun CheckB() {
    var kotlin by remember{ mutableStateOf(false) }
    var java by remember{ mutableStateOf(false) }
    var csharp by remember{ mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 50.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(uncheckedColor = Color.White)
            )
            Text(text = "Kotlin", color = Color.White)
        }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = java,
                onCheckedChange = { java = it },
                colors = CheckboxDefaults.colors(uncheckedColor = Color.White)
            )
            Text(text = "Java", color = Color.White)
        }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = csharp,
                onCheckedChange = { csharp = it },
                colors = CheckboxDefaults.colors(uncheckedColor = Color.White)
            )
            Text(text = "C#", color = Color.White)
        }
    }
}

@Composable
fun Radio() {
    var stackSelecionada by remember {
        mutableIntStateOf(-1)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                    .weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center)
            {
                RadioButton(
                    selected = stackSelecionada == 0,
                    onClick = { stackSelecionada = 0}
                )
                Text(text = "Backend", color = Color.White)
            }
            Row(
                modifier = Modifier
                    .weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center)
            {
                RadioButton(
                    selected = stackSelecionada == 1,
                    onClick = { stackSelecionada = 1 }
                )
                Text(text = "Frontend", color = Color.White)
            }
            Row(
                modifier = Modifier
                    .weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center)
            {
                RadioButton(
                    selected = stackSelecionada == 2,
                    onClick = { stackSelecionada = 2 }
                )
                Text(text = "Fullstack", color = Color.White)
            }
        }

    }
}

@Composable
fun Botao() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Button(
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDD5BE6),
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.White),
                shape = CircleShape
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Enviar"
                    )
                    Text(
                        text = "Enviar",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
            OutlinedButton(modifier = Modifier
                .size(width = 150.dp, height = 40.dp),
                onClick = {  },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Enviar"
                    )
                    Text(
                        text = "Enviar",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
        }


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

// RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp)
