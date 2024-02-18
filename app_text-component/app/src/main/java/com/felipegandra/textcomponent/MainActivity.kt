package com.felipegandra.textcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.textcomponent.ui.theme.Kablamo
import com.felipegandra.textcomponent.ui.theme.TextComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextComponentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .background(Color(0xFF212121))
            .fillMaxSize()
            .padding(20.dp)) {
        Text(
            modifier = Modifier
                .align(Alignment.Start),
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

        Spacer(modifier = Modifier.height(100.dp))

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

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Utilizando fonte externa",
            color = Color(180,180,180),
            fontWeight = FontWeight.Light,
            fontFamily = Kablamo,
            fontSize = 22.sp
        )

    }
}

@Preview
@Composable
fun GreetingPrev() {
    Greeting()
}


// Color(0xFFAB1212) -> Exadecimal 0x + Opacidade FF + AB1212
// padding(16.dp) -> todos os lados
// padding(horizontal = 32.dp) -> apenas no left e no right
// padding(vertical = 32.dp) -> apenas no top e no botton
// padding(horizontal = 20.dp, vertical = 32.dp) -> vertical e horizontal
// .padding(top = 16.dp, end = 10.dp, bottom = 10.dp, start = 12.dp) -> controles independentes
// Incluir fonte: Criar a pasta font dentro de res, criar a variável dentro de ui.theme/Type | val Kablamo = FontFamily(Font(R.font.kablammo_regular))
