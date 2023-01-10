package com.pratikpwr.coffeecompose.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.pratikpwr.coffeecompose.ui.theme.Purple500


@Composable
fun AppBar(
    title: String,
    prefixIcon: ImageVector,
    prefixIconOnTap: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        IconButton(onClick = prefixIconOnTap) {
            Icon(
                imageVector = prefixIcon,
                contentDescription = "Preffix Icon",
                tint = Purple500,
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
    }
}