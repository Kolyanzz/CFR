package com.kolumbo.chinesefoodrecipes.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
        recipes?.map {
            if (!prevsNames.contains(it.mCategoryName)) {
                (sectionRecipesLiveData.value as ArrayList).add(
                    SectionRecipes(
                        it.mCategoryName,
                        recipes.filter { r -> r.mCategoryName == it.mCategoryName })
                )
                prevsNames.add(it.mCategoryName)
            }
        }

        return _sectionRecipesLiveData
    }

}