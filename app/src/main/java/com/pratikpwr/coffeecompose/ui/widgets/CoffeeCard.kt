package com.pratikpwr.coffeecompose.ui.widgets

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import coil.compose.AsyncImage
import com.pratikpwr.coffeecompose.MainActivity
import com.pratikpwr.coffeecompose.model.CoffeeModel


@Preview
@Composable
fun CoffeeCardPreview() {
    CoffeeCard(
        coffee = CoffeeModel(
            id = 1,
            name = "Mocha",
            image = "https://upload.wikimedia.org/wikipedia/commons/f/f6/Mocaccino-Coffee.jpg",
        ), onAdd = {

        })
}


@Composable
fun CoffeeCard(coffee: CoffeeModel, onAdd: (CoffeeModel) -> Unit) {
    Card(
        elevation = 2.dp,
    ) {

        AsyncImage(
            model = coffee.image,
            contentDescription = "${coffee.name} image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    180.dp
                )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(text = coffee.name, style = MaterialTheme.typography.subtitle1)

                Text(text = coffee.price.toString(), style = MaterialTheme.typography.subtitle2)
            }
//            Spacer(modifier = Modifier.fillMaxWidth())
            Button(onClick = {
                onAdd(coffee)
            }) {
                Text(text = "Add".uppercase(), style = MaterialTheme.typography.button)
            }
        }

    }
}