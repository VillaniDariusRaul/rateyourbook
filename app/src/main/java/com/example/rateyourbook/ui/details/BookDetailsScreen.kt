package com.example.rateyourbook.ui.details

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.example.rateyourbook.data.Book
import com.example.rateyourbook.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.compose.material.icons.filled.Notifications
import com.example.rateyourbook.ui.components.AppTopBar

@Composable
fun BookDetailsScreen(
    book: Book,
    onBack: () -> Unit,
    onAddToList: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var query by remember { mutableStateOf("") }

    val backgroundColor by produceState(
        initialValue = Color(0xFFFFF0F5),
        key1 = book.imageRes
    ) {
        val rgb = withContext(Dispatchers.IO) {
            val bitmap = BitmapFactory.decodeResource(
                context.resources,
                book.imageRes
            )

            Palette.from(bitmap)
                .generate()
                .getDominantColor(android.graphics.Color.WHITE)
        }

        value = Color(rgb)
            .copy(alpha = 0.22f)
            .compositeOver(Color.White)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundPink)
            .verticalScroll(rememberScrollState())
    ) {

        // Search bar + Back button
        AppTopBar(
            showBackButton = true,
            onBack = onBack
        )

        // Book cover
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .width(190.dp)
                .height(270.dp)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(16.dp))
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = book.imageRes),
                contentDescription = book.title,
                modifier = Modifier
                    .width(160.dp)
                    .height(240.dp),
                contentScale = ContentScale.Fit
            )
        }

        // Title and author
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundPink)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineMedium,
                color = TextDark
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = "by ${book.author}",
                style = MaterialTheme.typography.titleMedium,
                color = TextDark
            )
        }

        // Separator
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp),
            color = BorderPink,
            thickness = 2.dp
        )

        // Description
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "About this book",
                style = MaterialTheme.typography.titleLarge,
                color = TextDark
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = book.description,
                style = MaterialTheme.typography.bodyLarge,
                color = TextDark
            )

            Spacer(Modifier.height(24.dp))

            // Add to list
            Button(
                onClick = onAddToList,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SeafoamGreenDark
                )
            ) {
                Text("Add to list")
            }
        }
    }
}