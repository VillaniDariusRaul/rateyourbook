package com.example.rateyourbook.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rateyourbook.ui.theme.*

@Composable
fun AppTopBar(
    showBackButton: Boolean = false,
    onBack: () -> Unit = {}
) {
    var query by remember { mutableStateOf("") }

    Surface(
        color = SeafoamGreen,
        shape = RoundedCornerShape(
            bottomStart = 28.dp,
            bottomEnd = 28.dp
        )
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackButton) {
                IconButton(onClick = onBack) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = OnSeafoamGreen
                    )
                }
            }

            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text("Search by title or author")
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                singleLine = true,
                shape = RoundedCornerShape(28.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = SearchPink,
                    unfocusedContainerColor = SearchPink,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            IconButton(onClick = { /* mai tarziu: notificari */ }) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = OnSeafoamGreen
                )
            }
        }
    }
}