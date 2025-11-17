package com.kabi.lazzypizza.core.presentation.designsystem.components.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kabi.lazzypizza.core.presentation.designsystem.ui.theme.LazzyPizzaTheme

@Composable
fun OutlineButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val textColor by animateColorAsState(
        targetValue = if (enabled) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.primary.copy(0.45f)
        }
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                color = if (enabled) MaterialTheme.colorScheme.primaryContainer.copy(0.2f) else MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable(
                indication = ripple(
                    color = MaterialTheme.colorScheme.primaryContainer
                ),
                interactionSource = interactionSource,
                enabled = enabled
            ) {
                onClick()
            }
            .padding(
                horizontal = 24.dp,
                vertical = 14.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(
                color = textColor
            ),
            maxLines = 1,
            autoSize = TextAutoSize.StepBased(
                minFontSize = 6.sp,
                stepSize = 1.sp,
                maxFontSize = MaterialTheme.typography.labelMedium.fontSize,
            )

        )
    }

}

@Preview(showBackground = true)
@Composable
private fun OutlineButtonPreview() {
    LazzyPizzaTheme {
        OutlineButton(
            title = "Label",
            onClick = {},
            enabled = false,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
        )
    }
}