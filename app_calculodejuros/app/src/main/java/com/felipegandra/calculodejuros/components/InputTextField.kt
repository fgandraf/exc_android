package com.felipegandra.calculodejuros.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    label : String,
    placeHolder : String,
    value : String,
    keyboardType : KeyboardType,
    modifier: Modifier,
    updateValue: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = updateValue,
        modifier = modifier.fillMaxWidth().padding(top = 16.dp),
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )

}