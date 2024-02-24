package com.felipegandra.meuscontatos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.meuscontatos.ui.theme.IndieFlower

@Composable
fun Header(text: String)
{
    Column(modifier = Modifier
        .background(color = Color(0xFF651f71))
        .fillMaxWidth()
        .height(150.dp),
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = IndieFlower,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center
        )
    }
}