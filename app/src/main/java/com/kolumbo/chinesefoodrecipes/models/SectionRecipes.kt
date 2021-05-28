package com.kolumbo.chinesefoodrecipes.models

import com.kolumbo.chinesefoodrecipes.database.Recipe

data class SectionRecipes(
    var name: String = "",
    var recipes: List<Recipe> = arrayListOf()
)