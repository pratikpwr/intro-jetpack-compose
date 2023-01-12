package com.pratikpwr.coffeecompose.presentation.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratikpwr.coffeecompose.ui.theme.Purple200
import com.pratikpwr.coffeecompose.ui.theme.Purple500

data class BottomNavScreen(
    val name: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val path: String
)

object BottomNavRoutes {
    val HomeScreen = BottomNavScreen(
        name = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        path = "home"
    );
    val FavouriteScreen = BottomNavScreen(
        name = "Favourite",
        selectedIcon = Icons.Filled.Favorite,
        unSelectedIcon = Icons.Outlined.Favorite,
        path = "favourite"
    );
    val ProfileScreen = BottomNavScreen(
        name = "Profile",
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        path = "profile"
    );

    val routes = listOf(HomeScreen, FavouriteScreen, ProfileScreen)
}


@Composable
fun BottomNavBarItem(item: BottomNavScreen, isSelected: Boolean = false, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(12.dp)
    ) {
        Icon(
            imageVector = if (isSelected) item.selectedIcon else item.unSelectedIcon,
            contentDescription = item.name,
            tint = if (isSelected) Purple500 else Purple200
        )
        Text(
            text = item.name,
            color = if (isSelected) Purple500 else Purple200,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavPreview() {
    val currentScreen = remember { mutableStateOf(BottomNavRoutes.HomeScreen.name) }

    BottomNavBar(currentScreen.value, onChange = { itemName ->
        currentScreen.value = itemName
    })
}

@Composable
fun BottomNavBar(selectedItem: String = BottomNavRoutes.HomeScreen.name, onChange: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        BottomNavRoutes.routes.forEach { item ->
            BottomNavBarItem(
                item,
                isSelected = selectedItem == item.name,
                modifier = Modifier.clickable { onChange(item.name) }
            )
        }
    }
}