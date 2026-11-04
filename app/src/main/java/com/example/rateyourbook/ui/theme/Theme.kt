
package com.example.rateyourbook.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = SeafoamGreenDark,
    onPrimary = Color.White,
    primaryContainer = SeafoamGreen,
    onPrimaryContainer = OnSeafoamGreen,

    secondary = AccentPink,
    onSecondary = Color.White,
    secondaryContainer = SearchPink,
    onSecondaryContainer = TextDark,

    background = BackgroundPink,
    onBackground = TextDark,

    surface = InputPink,
    onSurface = TextDark,

    surfaceContainer = BookCardPink,
    outline = BorderPink,
    outlineVariant = BorderPink
)

@Composable
fun RateyourbookTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
