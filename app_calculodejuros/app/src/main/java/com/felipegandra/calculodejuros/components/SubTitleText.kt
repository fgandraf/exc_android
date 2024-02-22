package com.felipegandra.calculodejuros.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SubTitleText(text : String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold
    )
}