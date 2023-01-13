package com.pratikpwr.coffeecompose.ui.dashboard

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.pratikpwr.coffeecompose.ui.screens.FavouriteScreen
import com.pratikpwr.coffeecompose.ui.screens.MenuScreen
import com.pratikpwr.coffeecompose.ui.screens.ProfileScreen


@Preview
@Composable
fun Dashboard() {
    val currentScreen = remember { mutableStateOf(BottomNavRoutes.MenuScreen.name) }

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
        when (currentScreen.value) {
            BottomNavRoutes.MenuScreen.name -> MenuScreen()
            BottomNavRoutes.FavouriteScreen.name -> FavouriteScreen()
            BottomNavRoutes.ProfileScreen.name -> ProfileScreen()
        }
    }
}