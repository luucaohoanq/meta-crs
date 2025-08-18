package com.lcaohoanq.littlelemon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lcaohoanq.littlelemon.models.Food
import com.lcaohoanq.littlelemon.models.FoodData
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonGreen
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonOrange
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonPink
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonTheme
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonYellow
import com.lcaohoanq.littlelemon.ui.theme.PureWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodDetailScreen(
    food: Food,
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var quantity by remember { mutableStateOf(1) }
    val totalPrice = food.price * quantity

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Top App Bar
        TopAppBar(
            title = { Text("Food Details") },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = LittleLemonYellow,
                titleContentColor = PureWhite,
                navigationIconContentColor = PureWhite
            )
        )
        
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Food Image Placeholder
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = LittleLemonPink.copy(alpha = 0.3f)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🍽️",
                        fontSize = 120.sp
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Food Name
            Text(
                text = food.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = LittleLemonGreen
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Category Badge
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = LittleLemonOrange.copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = food.category.displayName,
                    style = MaterialTheme.typography.labelLarge,
                    color = LittleLemonGreen,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Price
            Text(
                text = "$${String.format("%.2f", food.price)}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = LittleLemonGreen
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Description
            Text(
                text = "Description",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = LittleLemonGreen
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = food.description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                lineHeight = 24.sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Quantity Selector
            Text(
                text = "Quantity",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = LittleLemonGreen
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = { if (quantity > 1) quantity-- },
                    modifier = Modifier.size(48.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("-", fontSize = 20.sp)
                }
                
                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                OutlinedButton(
                    onClick = { quantity++ },
                    modifier = Modifier.size(48.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("+", fontSize = 20.sp)
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Total Price and Add to Cart
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = LittleLemonYellow
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Total",
                                style = MaterialTheme.typography.titleMedium,
                                color = LittleLemonGreen
                            )
                            Text(
                                text = "$${String.format("%.2f", totalPrice)}",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = LittleLemonGreen
                            )
                        }
                        
                        Button(
                            onClick = { /* Add to cart logic */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = LittleLemonGreen
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Add to Cart",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodDetailScreenPreview() {
    LittleLemonTheme {
        FoodDetailScreen(
            food = FoodData.sampleFoods.first()
        )
    }
}
