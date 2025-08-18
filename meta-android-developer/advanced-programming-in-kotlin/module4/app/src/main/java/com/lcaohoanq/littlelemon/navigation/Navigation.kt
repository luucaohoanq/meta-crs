package com.lcaohoanq.littlelemon.navigation

import androidx.compose.runtime.*
import com.lcaohoanq.littlelemon.models.Food

sealed class Screen {
    object Home : Screen()
    data class FoodDetail(val food: Food) : Screen()
}

@Composable
fun rememberNavigationState(): NavigationState {
    return remember { NavigationState() }
}

class NavigationState {
    private var _currentScreen by mutableStateOf<Screen>(Screen.Home)
    val currentScreen: Screen get() = _currentScreen
    
    fun navigateToFoodDetail(food: Food) {
        _currentScreen = Screen.FoodDetail(food)
    }
    
    fun navigateToHome() {
        _currentScreen = Screen.Home
    }
    
    fun goBack() {
        when (_currentScreen) {
            is Screen.Home -> { /* Already at home, do nothing */ }
            is Screen.FoodDetail -> navigateToHome()
        }
    }
}
