package com.lcaohoanq.littlelemon.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonGreen
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonTheme
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonYellow

@Composable
fun LittleLemonButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = LittleLemonYellow,
            contentColor = LittleLemonGreen,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun FoodImagePlaceholder(
    modifier: Modifier = Modifier,
    emoji: String = "🍽️",
    emojiSize: Int = 32
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = LittleLemonYellow.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = emoji,
                fontSize = emojiSize.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LittleLemonButtonPreview() {
    LittleLemonTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LittleLemonButton(
                text = "Add to Cart",
                onClick = {}
            )
            LittleLemonButton(
                text = "Disabled Button",
                onClick = {},
                enabled = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodImagePlaceholderPreview() {
    LittleLemonTheme {
        FoodImagePlaceholder(
            modifier = Modifier.size(100.dp)
        )
    }
}
