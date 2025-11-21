package com.kabi.lazzypizza.core.presentation.util

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kabi.lazzypizza.core.presentation.designsystem.ui.theme.Outline

@Composable
fun IconButtonWithBorder(
    onClick: () -> Unit,
    contentColor: Color,
    icon: ImageVector
) {
    IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = contentColor,
        ),
        modifier = Modifier
            .size(30.dp)
    ) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .border(
                    width = 1.dp,
                    color = Outline,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Remove",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}