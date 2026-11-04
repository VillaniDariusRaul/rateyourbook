package com.example.rateyourbook.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.rateyourbook.ui.theme.SeafoamGreen
import com.example.rateyourbook.ui.theme.OnSeafoamGreen
import com.example.rateyourbook.ui.theme.BackgroundPink
import com.example.rateyourbook.ui.theme.ButtonPink

enum class Tab(val label: String, val icon: ImageVector) {
    Home("Home", Icons.Default.Home),
    Search("Search", Icons.Default.Search),
    Lists("Lists", Icons.Default.Book),
    Profile("Profile", Icons.Default.Person)
}

@Composable
fun AppBottomBar(selected: Tab, onSelect: (Tab) -> Unit) {
    NavigationBar(
        containerColor = ButtonPink,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
    ) {
        Tab.entries.forEach { tab ->
            NavigationBarItem(
                selected = tab == selected,
                onClick = { onSelect(tab) },
                icon = { Icon(tab.icon, contentDescription = tab.label) },
                label = { Text(tab.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = OnSeafoamGreen,
                    selectedTextColor = OnSeafoamGreen,
                    unselectedIconColor = OnSeafoamGreen.copy(alpha = 0.6f),
                    unselectedTextColor = OnSeafoamGreen.copy(alpha = 0.6f),
                    indicatorColor = BackgroundPink
                )
            )
        }
    }
}