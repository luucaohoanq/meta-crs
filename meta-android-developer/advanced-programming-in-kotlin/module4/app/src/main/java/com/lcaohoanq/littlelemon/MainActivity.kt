package com.lcaohoanq.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lcaohoanq.littlelemon.navigation.Screen
import com.lcaohoanq.littlelemon.navigation.rememberNavigationState
import com.lcaohoanq.littlelemon.ui.screens.FoodDetailScreen
import com.lcaohoanq.littlelemon.ui.screens.HomeScreen
import com.lcaohoanq.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                LittleLemonApp()
            }
        }
    }
}

@Composable
fun LittleLemonApp() {
    val navigationState = rememberNavigationState()
    
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when (val screen = navigationState.currentScreen) {
            is Screen.Home -> {
                HomeScreen(
                    onFoodClick = { food -> navigationState.navigateToFoodDetail(food) },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            is Screen.FoodDetail -> {
                FoodDetailScreen(
                    food = screen.food,
                    onBackClick = { navigationState.goBack() },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAllScreen(){
    LittleLemonTheme {
        LittleLemonApp()
    }
}