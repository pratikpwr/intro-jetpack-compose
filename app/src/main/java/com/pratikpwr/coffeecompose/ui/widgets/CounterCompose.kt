package com.pratikpwr.coffeecompose.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CounterCompose() {
    val count = remember {
        mutableStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter Compose",
            Modifier.padding(16.dp),
            style = MaterialTheme.typography.h5
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (count.value > 0) {
                    count.value -= 1
                }
            }) {
                Text(
                    text = "-",
                    fontSize = 24.sp
                )
            }
            Text(
                text = count.value.toString(),
                Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
                fontSize = 24.sp
            )
            Button(onClick = {
                count.value += 1
            }) {
                Text(
                    text = "+",
                    fontSize = 24.sp
                )
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = count.value.toString(), onValueChange = {
            val number = it.toIntOrNull()
            if (number != null) {
                count.value = number
            }
        })
    }
}