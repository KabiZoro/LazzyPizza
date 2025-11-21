package com.kabi.lazzypizza.core.presentation.designsystem.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF03131F)
val Primary20 = Color(0xFFFFFFFF)
val PrimaryContainer = Color(0xFFF36B50)
val PrimaryContainer20 = Color(0xFFF36B5014)

val Secondary = Color(0xFF627686)
val Secondary20 = Color(0xFF62768614)

val Background = Color(0xFFFAFBFC)

val Surface = Color(0xFFFFFFFF)
val Surface20 = Color(0xFFF0F3F6)

val Outline = Color(0xFFE6E7ED)
val Outline20 = Color(0xFFE6E7ED80)

val ColorScheme.buttonGradient: Brush
    get() = Brush.linearGradient(
        listOf(
            Color(0xFFF9966F),
            Color(0xFFF36B50)
        )
    )

val ColorScheme.disabledButtonGradient: Color
    get() = Color(0xFFF36B50).copy(0.2f)
