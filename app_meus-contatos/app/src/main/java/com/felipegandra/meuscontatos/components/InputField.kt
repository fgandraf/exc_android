package com.felipegandra.meuscontatos.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    value: String,
    label: String,
    keyboard: KeyboardType = KeyboardType.Text,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    onChange: (String) -> Unit
    ) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboard,
            capitalization = capitalization
        )
    )
}