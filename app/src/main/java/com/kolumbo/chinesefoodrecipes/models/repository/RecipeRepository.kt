package com.kolumbo.chinesefoodrecipes.models.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kolumbo.chinesefoodrecipes.database.Recipe
import com.kolumbo.chinesefoodrecipes.database.RecipesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RecipeRepository(
    private val mRecipeDao: RecipesDao
) {
    var allRecipes: LiveData<List<Recipe>> = MutableLiveData()

    fun getAllRecipes() {
        GlobalScope.launch(Dispatchers.IO) {
            allRecipes = mRecipeDao.getAllRecipes()
        }
    }
}