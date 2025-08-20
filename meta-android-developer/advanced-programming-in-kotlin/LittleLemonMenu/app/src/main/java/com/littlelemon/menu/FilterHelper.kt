package com.littlelemon.menu

class FilterHelper {
    // create a FilterHelperTest and write a unit test for filterProducts
    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList
            FilterType.Dessert -> productsList.filter { it.category.equals("Dessert", ignoreCase = true) }
            FilterType.Drinks -> productsList.filter { it.category.equals("Drinks", ignoreCase = true) }
            FilterType.Food -> productsList.filter { it.category.equals("Food", ignoreCase = true) }
        }
    }

}