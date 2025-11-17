package com.kabi.lazzypizza.core.presentation.designsystem.components.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kabi.lazzypizza.core.presentation.designsystem.ui.theme.LazzyPizzaTheme
import com.kabi.lazzypizza.core.presentation.designsystem.ui.theme.buttonGradient

@Composable
fun FilledButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {

    val textColor by animateColorAsState(
        targetValue = if (enabled) {
            MaterialTheme.colorScheme.onPrimary
        } else {
            MaterialTheme.colorScheme.primary.copy(0.45f)
        }
    )

    Box(
        modifier = modifier
            .then(
                if (enabled) {
                    Modifier
                        .dropShadow(
                            shape = RoundedCornerShape(50.dp),
                            shadow = Shadow(
                                radius = 4.dp,
                                spread = 1.8.dp,
                                color = MaterialTheme.colorScheme.primaryContainer.copy(0.25f)
                            )
                        )

                } else {
                    Modifier
                }
            )
            .clip(RoundedCornerShape(50.dp))
            .background(
                if (enabled) {
                    MaterialTheme.colorScheme.buttonGradient
                } else {
                    SolidColor(MaterialTheme.colorScheme.primary.copy(0.08f))
                },
                RoundedCornerShape(50.dp)
            )
            .clickable(
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
private fun FilledButtonPreview() {
    LazzyPizzaTheme {
        FilledButton(
            title = "Label",
            onClick = {},
            enabled = false,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
        )
    }
}