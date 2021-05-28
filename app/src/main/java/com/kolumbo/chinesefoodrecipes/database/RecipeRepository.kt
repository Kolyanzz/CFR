package com.kolumbo.chinesefoodrecipes.database

class RecipeRepository(
    private val mRecipeDao: RecipesDao
) {
    val allRecipes = mRecipeDao.getAllRecipes()
}