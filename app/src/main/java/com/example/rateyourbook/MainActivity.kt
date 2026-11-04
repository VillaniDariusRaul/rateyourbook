package com.example.rateyourbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.rateyourbook.data.Book
import com.example.rateyourbook.ui.home.HomeScreen
import com.example.rateyourbook.ui.theme.RateyourbookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RateyourbookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        books = listOf(
                            Book(
                                1,
                                "1984",
                                "George Orwell",
                                "A dystopian novel about totalitarian surveillance, propaganda and the loss of individual freedom."
                            ),
                            Book(
                                2,
                                "Dune",
                                "Frank Herbert",
                                "An epic science fiction story about politics, religion and survival on the desert planet Arrakis."
                            ),
                            Book(
                                3,
                                "Demons",
                                "Fyodor Dostoevsky",
                                "A novel about a group of radicals in a provincial Russian town and the destructive power of nihilistic ideas."
                            )
                        ),
                        onBookClick = { },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}