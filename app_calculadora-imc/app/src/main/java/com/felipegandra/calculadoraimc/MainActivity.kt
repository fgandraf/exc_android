package com.felipegandra.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   IMCScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IMCScreenPreview() {
    IMCScreen()
}


@Composable
fun IMCScreen()
{

    var peso by remember {
        mutableStateOf("")
    }
    var altura by remember {
        mutableStateOf("")
    }
    var imc by remember {
        mutableDoubleStateOf(0.0)
    }
    var statusImc by remember {
        mutableStateOf("")
    }

    var corResultado by remember {
        mutableStateOf(Color(0xFF648264))
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
       Column(
           modifier = Modifier
               .fillMaxWidth()
       ) {
           // ----- header -----
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(220.dp)
                   .background(colorResource(id = R.color.vermelho_fiap)),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Spacer(modifier = Modifier.height(16.dp))
               Image(
                  modifier = Modifier
                      .size(80.dp)
                      .padding(top = 8.dp),
                  painter = painterResource(id = R.drawable.imc),
                  contentDescription = "logo"
               )
               Text(
                   modifier = Modifier
                       .padding(top = 8.dp),
                   text = "CALCULADORA IMC",
                   fontSize = 20.sp,
                   color = Color.White,
                   fontWeight = FontWeight.Bold
               )
           }

           // ----- formulário -----
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = 32.dp)
           ) {
               Card( modifier = Modifier
                   .fillMaxWidth()
                   .offset(y = (-40).dp),
                   colors = CardDefaults.cardColors(containerColor = Color.White),
                   elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                   shape = RoundedCornerShape(16.dp)
               ) {
                   Column(
                       modifier = Modifier
                           .padding(top = 20.dp, start = 32.dp, end = 32.dp, bottom = 25.dp),
                       verticalArrangement = Arrangement.Center
                   ) {
                       Text(
                           text = "Seus dados",
                           modifier = Modifier.fillMaxWidth(),
                           fontSize = 22.sp,
                           fontWeight = FontWeight.Bold,
                           color = colorResource(id = R.color.vermelho_fiap),
                           textAlign = TextAlign.Center
                       )
                       Spacer(modifier = Modifier.height(32.dp))
                       Text(
                           text = "Seu peso",
                           modifier = Modifier.padding(bottom = 8.dp),
                           fontSize = 12.sp,
                           fontWeight = FontWeight.Normal,
                           color = colorResource(id = R.color.vermelho_fiap)
                       )
                       OutlinedTextField(
                           value = peso,
                           onValueChange = { peso = it },
                           modifier = Modifier.fillMaxWidth(),
                           placeholder = {
                               Text(text = "Seu peso em kg.")
                           },
                           colors = OutlinedTextFieldDefaults.colors(
                               unfocusedBorderColor = colorResource(id = R.color.vermelho_fiap),
                               focusedBorderColor = colorResource(id = R.color.vermelho_fiap)
                           ),
                           shape = RoundedCornerShape(16.dp),
                           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                       )
                       Spacer(modifier = Modifier.height(16.dp))
                       Text(
                           text = "Sua altura",
                           modifier = Modifier.padding(bottom = 8.dp),
                           fontSize = 12.sp,
                           fontWeight = FontWeight.Normal,
                           color = colorResource(id = R.color.vermelho_fiap)
                       )
                       OutlinedTextField(
                           value = altura,
                           onValueChange = { altura = it},
                           modifier = Modifier.fillMaxWidth(),
                           placeholder = {
                               Text(
                                   text = "Sua altura em cm."
                               )
                           },
                           colors = OutlinedTextFieldDefaults.colors(
                               unfocusedBorderColor = colorResource(id = R.color.vermelho_fiap),
                               focusedBorderColor = colorResource(id = R.color.vermelho_fiap)
                           ),
                           shape = RoundedCornerShape(16.dp),
                           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                       )
                       Spacer(modifier = Modifier.height(46.dp))
                       Button(
                           onClick = {
                               imc = calcularImc(peso = peso.toDouble(), altura = altura.toDouble())
                               val resultado = obterStatusImc(imc)
                               statusImc = resultado.first
                               corResultado = resultado.second
                           },
                           modifier = Modifier
                               .fillMaxWidth()
                               .height(48.dp),
                           shape = RoundedCornerShape(16.dp),
                           colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho_fiap))
                       ) {
                           Text(
                               text = "CALCULAR",
                               fontWeight = FontWeight.Bold,
                               color = Color.White,
                               fontSize = 14.sp
                           )
                       }
                   }

               }
           }
       }



        // --- card resultado
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(32.dp)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(containerColor = corResultado),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxSize()
            ) {
                Column {
                    Text(
                        text = "Resultado",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Text(
                        text = statusImc,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Text(
                    text = String.format("%.1f", imc),
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.End
                )
            }
        }

    }


}