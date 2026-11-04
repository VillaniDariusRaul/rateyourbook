package com.example.rateyourbook.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rateyourbook.data.Book
import com.example.rateyourbook.ui.theme.SeafoamGreen
import com.example.rateyourbook.ui.theme.SeafoamGreenLight
import com.example.rateyourbook.ui.theme.OnSeafoamGreen
import com.example.rateyourbook.ui.theme.SearchPink
import com.example.rateyourbook.ui.theme.BackgroundPink
import com.example.rateyourbook.ui.theme.BookCardPink
import androidx.compose.foundation.layout.fillMaxSize
import com.example.rateyourbook.ui.theme.ButtonPink
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import com.example.rateyourbook.ui.components.AppTopBar

@Composable
fun HomeScreen(
    books: List<Book>,
    onBookClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundPink)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
        // Bara de sus: cu colțuri rotunjite jos
            AppTopBar()

        // Lista de cărți
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(books, key = { it.id }) { book ->
                BookItem(
                    book = book,
                    onClick = { onBookClick(book.id) },
                    onAddToList = { /* mai târziu: salvare în listă */ }
                )
            }
        }
    }}
}

@Composable
private fun BookItem(
    book: Book,
    onClick: () -> Unit,
    onAddToList: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SeafoamGreenLight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = book.imageRes),
                contentDescription = book.title,
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Fit
            )

            Spacer(Modifier.width(14.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        book.title,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        "by ${book.author}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Button(
                    onClick = onAddToList,
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Add to list")
                }
            }
        }
    }
}