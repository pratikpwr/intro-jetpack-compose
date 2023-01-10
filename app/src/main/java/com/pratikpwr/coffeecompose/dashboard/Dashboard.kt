package com.pratikpwr.coffeecompose.dashboard

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.pratikpwr.coffeecompose.ui.theme.Purple500


@Preview
@Composable
fun Dashboard() {
    val currentScreen = remember { mutableStateOf(BottomNavRoutes.HomePage.name) }

    Scaffold(
        topBar = {
            AppBar(
                title = currentScreen.value,
                prefixIcon = Icons.Filled.Menu,
                prefixIconOnTap = {
                    // todo : Open Drawer
                }
            )
        },
        bottomBar = {
            BottomNavBar(currentScreen.value, onChange = { itemName ->
                currentScreen.value = itemName
            })
        }
    ) {

    }
}