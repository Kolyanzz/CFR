package com.kolumbo.chinesefoodrecipes.models

data class RecipeFirestore(
    var recipeName: String = "",
    var recipeDescription: String = "",
    var foodPicturePath: String = "",
    var recipeRating: Int = 0,
    var categoryName: String = "",
)