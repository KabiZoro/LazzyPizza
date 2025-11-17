package com.kabi.lazzypizza.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    onSecondary = Secondary20,
    onPrimary = Primary20,
    background = Background,
    onSurface = Surface,
    onSurfaceVariant = Surface20,
    outline = Outline,
    outlineVariant = Outline20,
    primaryContainer = PrimaryContainer,
    onPrimaryFixed = PrimaryContainer20
)

@Composable
fun LazzyPizzaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}