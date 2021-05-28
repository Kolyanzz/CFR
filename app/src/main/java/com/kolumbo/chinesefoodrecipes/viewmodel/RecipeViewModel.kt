package com.kolumbo.chinesefoodrecipes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kolumbo.chinesefoodrecipes.database.Recipe
import com.kolumbo.chinesefoodrecipes.database.RecipeRepository
import com.kolumbo.chinesefoodrecipes.database.RecipesDatabase

class RecipeViewModel(mApp: Application) : AndroidViewModel(mApp) {

    private val mAllRecipes: LiveData<List<Recipe>>
    private val mRepository: RecipeRepository

    init {
        val recipeDao = RecipesDatabase.get(mApp).recipesDao()
        mRepository = RecipeRepository(recipeDao)
        mAllRecipes = mRepository.allRecipes
    }
}