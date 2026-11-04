package com.example.rateyourbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.rateyourbook.data.Book
import com.example.rateyourbook.ui.components.AppBottomBar
import com.example.rateyourbook.ui.components.Tab
import com.example.rateyourbook.ui.home.HomeScreen
import com.example.rateyourbook.ui.theme.RateyourbookTheme
import com.example.rateyourbook.ui.theme.BackgroundPink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val books = listOf(
            Book(
                1, "1984", "George Orwell",
                "A dystopian novel about totalitarian surveillance, propaganda and the loss of individual freedom.",
                R.drawable.book_1984
            ),
            Book(
                2, "Dune", "Frank Herbert",
                "An epic science fiction story about politics, religion and survival on the desert planet Arrakis.",
                R.drawable.book_dune
            ),
            Book(
                3, "Demons", "Fyodor Dostoevsky",
                "A novel about a group of radicals in a provincial Russian town and the destructive power of nihilistic ideas.",
                R.drawable.book_demons
            )
        )

        setContent {
            RateyourbookTheme {
                var selectedTab by remember { mutableStateOf(Tab.Home) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = BackgroundPink,
                    bottomBar = {
                        AppBottomBar(
                            selected = selectedTab,
                            onSelect = { selectedTab = it }
                        )
                    }
                ) { innerPadding ->
                    HomeScreen(
                        books = books,
                        onBookClick = { },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = innerPadding.calculateBottomPadding())
                    )
                }
            }
        }
    }
}