package com.kolumbo.chinesefoodrecipes.ui.fragments.home;

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kolumbo.chinesefoodrecipes.database.Recipe
import com.kolumbo.chinesefoodrecipes.database.RecipesDatabase
import com.kolumbo.chinesefoodrecipes.models.SectionRecipes
import com.kolumbo.chinesefoodrecipes.models.repository.RecipeRepository

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    private val recipesDao = RecipesDatabase.get(app).recipesDao()
private val recipesRepository = RecipeRepository(recipesDao)
        init {
        recipesRepository.getAllRecipes()
        }
private var sectionRecipesLiveData: MutableLiveData<List<SectionRecipes>> = MutableLiveData()
private var _sectionRecipesLiveData: LiveData<List<SectionRecipes>> = sectionRecipesLiveData
        fun getSectionRecipes(): LiveData<List<SectionRecipes>> {
        val recipes = recipesRepository.allRecipes.value
        val prevsNames = arrayListOf<String>()
        Log.d("TEST_LOG", "getSectionRecipes: $recipes")
        recipes?.map {
        if (!prevsNames.contains(it.categoryName)) {
        (sectionRecipesLiveData.value as ArrayList).add(
        SectionRecipes(
        it.categoryName.toString(),
        recipes.filter { r -> r.categoryName == it.categoryName })
        )
        prevsNames.add(it.categoryName.toString())
        }
        }

        return _sectionRecipesLiveData
        }

        fun searchRecipes(q: String, onSuccess: (recipes: List<Recipe>) -> Unit) {
        recipesRepository.searchRecipes(q, onSuccess)
        }

        }