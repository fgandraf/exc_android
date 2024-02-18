package com.felipegandra.columnrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipegandra.columnrow.ui.theme.ColumnRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnRowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LayoutScreen()
                }
            }
        }
    }
}



@Composable
fun LayoutScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {

        Column(modifier = Modifier.fillMaxWidth().background(Color.Red).height(50.dp)) {}
        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.fillMaxWidth().background(Color.Red).height(50.dp)) {}
        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.fillMaxWidth().background(Color.Red).height(50.dp)) {}
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth().height(50.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(modifier = Modifier.padding(0.dp, 0.dp, 5.dp, 0.dp).background(Color.Red).height(50.dp).weight(0.33f)) {}

            Column(modifier = Modifier.padding(5.dp, 0.dp, 5.dp, 0.dp).background(Color.Red).height(50.dp).weight(0.33f)) {}

            Column(modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp).background(Color.Red).height(50.dp).weight(0.33f)) {}
        }
        Spacer(modifier = Modifier.height(10.dp))
        
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth().weight(0.5f)) {

                Column(modifier = Modifier.background(Color.Red).height(50.dp).fillMaxWidth()) {}
                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.background(Color.Red).height(50.dp).fillMaxWidth()) {}
                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.background(Color.Red).height(50.dp).fillMaxWidth()) {}
            }
            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.fillMaxWidth().weight(0.5f)) {
                Column(modifier = Modifier.background(Color.Red).height(50.dp).fillMaxWidth()) {}
                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.background(Color.Red).height(50.dp).fillMaxWidth()) {}
                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.background(Color.Red).height(50.dp).fillMaxWidth()) {}
            }
        }
    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnsAndRowsPreview() {
    ColumnRowTheme {
        LayoutScreen()
    }
}

