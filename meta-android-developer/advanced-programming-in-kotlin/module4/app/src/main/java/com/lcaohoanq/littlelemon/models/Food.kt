package com.lcaohoanq.littlelemon.models

data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val category: FoodCategory,
    val imageUrl: String
)

enum class FoodCategory(val displayName: String) {
    DRINKS("Drinks"),
    FOOD("Food"),
    DESSERT("Dessert")
}

object FoodData {
    val sampleFoods = listOf(
        Food(
            id = 1,
            name = "Latte",
            description = "Rich and creamy espresso-based coffee drink with steamed milk and a light layer of foam. Perfect for coffee lovers who enjoy a smooth, balanced flavor.",
            price = 8.0,
            category = FoodCategory.DRINKS,
            imageUrl = "https://example.com/latte.jpg"
        ),
        Food(
            id = 2,
            name = "Mocha",
            description = "Decadent chocolate and espresso blend topped with whipped cream. A delightful treat that combines the best of coffee and chocolate.",
            price = 9.5,
            category = FoodCategory.DRINKS,
            imageUrl = "https://example.com/mocha.jpg"
        ),
        Food(
            id = 3,
            name = "Boeuf Bourguignon",
            description = "Classic French beef stew slow-cooked in red wine with vegetables and herbs. Tender, flavorful, and deeply satisfying.",
            price = 24.0,
            category = FoodCategory.FOOD,
            imageUrl = "https://example.com/boeuf.jpg"
        ),
        Food(
            id = 4,
            name = "Bouillabaisse",
            description = "Traditional Provençal fish stew with aromatic herbs and saffron. A Mediterranean delicacy that brings the taste of the sea to your table.",
            price = 28.0,
            category = FoodCategory.FOOD,
            imageUrl = "https://example.com/bouillabaisse.jpg"
        ),
        Food(
            id = 5,
            name = "Lasagna",
            description = "Layers of pasta, rich meat sauce, and melted cheese baked to perfection. A comforting Italian classic that never disappoints.",
            price = 18.0,
            category = FoodCategory.FOOD,
            imageUrl = "https://example.com/lasagna.jpg"
        ),
        Food(
            id = 6,
            name = "Onion Soup",
            description = "French onion soup with caramelized onions, rich broth, and melted Gruyère cheese. Warm and comforting on any day.",
            price = 12.0,
            category = FoodCategory.FOOD,
            imageUrl = "https://example.com/onion_soup.jpg"
        ),
        Food(
            id = 7,
            name = "Salmon en Papillote",
            description = "Fresh salmon baked in parchment with vegetables and herbs. Light, healthy, and bursting with natural flavors.",
            price = 26.0,
            category = FoodCategory.FOOD,
            imageUrl = "https://example.com/salmon.jpg"
        ),
        Food(
            id = 8,
            name = "Quiche Lorraine",
            description = "Traditional French quiche with bacon, cheese, and eggs in a buttery pastry crust. Perfect for brunch or a light dinner.",
            price = 16.0,
            category = FoodCategory.FOOD,
            imageUrl = "https://example.com/quiche.jpg"
        ),
        Food(
            id = 9,
            name = "Custard Tart",
            description = "Smooth, creamy custard in a crisp pastry shell. A timeless dessert that melts in your mouth.",
            price = 8.5,
            category = FoodCategory.DESSERT,
            imageUrl = "https://example.com/custard_tart.jpg"
        ),
        Food(
            id = 10,
            name = "Croissant",
            description = "Buttery, flaky French pastry that's perfect for breakfast or as a light snack. Crisp outside, tender inside.",
            price = 5.0,
            category = FoodCategory.DESSERT,
            imageUrl = "https://example.com/croissant.jpg"
        )
    )
    
    fun getFoodById(id: Int): Food? = sampleFoods.find { it.id == id }
    
    fun getFoodsByCategory(category: FoodCategory): List<Food> = 
        sampleFoods.filter { it.category == category }
}
