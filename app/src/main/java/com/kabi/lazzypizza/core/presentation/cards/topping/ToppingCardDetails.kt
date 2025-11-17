package com.kabi.lazzypizza.core.presentation.cards.topping

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kabi.lazzypizza.R
import com.kabi.lazzypizza.core.presentation.theme.PrimaryContainer
import com.kabi.lazzypizza.util.instrumentSans

@Composable
fun ToppingCards(
    topping: ToppingCard,
    modifier: Modifier = Modifier
) {
    var quantity by remember {
        mutableStateOf(0)
    }
    Card(
        modifier = modifier
            .width(150.dp)
            .height(IntrinsicSize.Max)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                quantity = 1
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (quantity == 0) Color(0xFFF0F3F6)
            else PrimaryContainer
        )
    ) {
        Image(
            painter = painterResource(topping.image),
            contentDescription = topping.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = topping.name,
            fontFamily = instrumentSans,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (quantity == 0) {
            Row(
                modifier = Modifier
                    .width(150.dp)
                    .align(Alignment.CenterHorizontally)
                    .weight(1f)
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${topping.price}",
                    fontFamily = instrumentSans,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        } else {
            Row(
                modifier = Modifier
                    .width(150.dp)
                    .align(Alignment.CenterHorizontally)
                    .weight(1f)
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Remove",
                    modifier = Modifier
                        .clickable {
                            if (quantity > 1) {
                                quantity--
                            } else quantity = 0
                        }
                )
                Text(
                    text = quantity.toString(),
                    fontFamily = instrumentSans,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineSmall
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .clickable {
                            quantity++
                        }
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ToppingCardsPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        ToppingCards(
            topping = ToppingCard(
                image = R.drawable.app_icon,
                name = "Topping",
                price = "1"
            )
        )
    }
}