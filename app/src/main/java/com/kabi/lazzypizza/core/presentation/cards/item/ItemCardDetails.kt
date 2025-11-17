package com.kabi.lazzypizza.core.presentation.cards.item

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kabi.lazzypizza.R
import com.kabi.lazzypizza.core.presentation.theme.Minus
import com.kabi.lazzypizza.core.presentation.theme.Outline
import com.kabi.lazzypizza.core.presentation.theme.Plus
import com.kabi.lazzypizza.core.presentation.theme.Primary
import com.kabi.lazzypizza.core.presentation.theme.PrimaryContainer
import com.kabi.lazzypizza.core.presentation.theme.Secondary
import com.kabi.lazzypizza.core.presentation.theme.Trash
import com.kabi.lazzypizza.core.presentation.util.IconButtonWithBorder
import com.kabi.lazzypizza.util.instrumentSans

@Composable
fun ItemCards(
    item: ItemCard,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                if (quantity == 0) {
                    onQuantityChange(1)
                }
            },
        border = BorderStroke(
            width = 2.dp,
            color = Color(0xFFFFFFFF)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFFFFFFF)
                )
                .animateContentSize()
        ) {
            Image(
                painter = painterResource(item.image),
                contentDescription = item.name,
                modifier = Modifier
                    .background(
                        Color(0xFFF0F3F6)
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if (quantity == 0) {
                    Text(
                        text = item.name,
                        fontFamily = instrumentSans,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = item.description,
                        fontFamily = instrumentSans,
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$${item.price}",
                        fontFamily = instrumentSans,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.headlineMedium
                    )
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item.name,
                            fontFamily = instrumentSans,
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        IconButtonWithBorder(
                            onClick = {
                                onQuantityChange(0)
                            },
                            contentColor = PrimaryContainer,
                            icon = Icons.Filled.Trash
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButtonWithBorder(
                            onClick = {
                                onQuantityChange(quantity - 1)
                            },
                            contentColor = Secondary,
                            icon = Icons.Filled.Minus
                        )
                        Text(
                            text = quantity.toString(),
                            fontFamily = instrumentSans,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        IconButtonWithBorder(
                            onClick = {
                                onQuantityChange(quantity + 1)
                            },
                            contentColor = Secondary,
                            icon = Icons.Filled.Plus
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            modifier = Modifier,
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.End
                        ) {
                            val total = item.price.toDouble() * quantity
                            Text(
                                text = "$${total}",
                                fontFamily = instrumentSans,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "$quantity x $${item.price}",
                                fontFamily = instrumentSans,
                                fontWeight = FontWeight.Light,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemCardsPreview() {

    val itemQuantities = remember { mutableStateOf(mapOf<Int, Int>()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        items(20) { index ->

            val quantity = itemQuantities.value[index] ?: 0

            ItemCards(
                item = ItemCard(
                    image = R.drawable.app_icon,
                    name = "Item $index",
                    description = "Description of item $index",
                    price = "8.99"
                ),
                quantity = quantity,
                onQuantityChange = { newQuantity ->
                    val currentMap = itemQuantities.value.toMutableMap()
                    if (newQuantity <= 0) {
                        currentMap.remove(index)
                    } else {
                        currentMap[index] = newQuantity
                    }
                    itemQuantities.value = currentMap
                },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }


}