package com.kolumbo.chinesefoodrecipes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Интерфейс для общения с БД
 *
 * @author Egor Ponomarev
 */
@Dao
interface RecipesDao {
    @Update
    fun updateRecipe(vararg recipe: Recipe)

    @Insert
    fun addRecipe(vararg newRecipe: Recipe)

    @Query("SELECT * FROM recipesTable WHERE mId = :id")
    suspend fun getRecipeById(id: Int): Recipe

    @Query("SELECT * FROM recipesTable")
    fun getAllRecipes(): LiveData<List<Recipe>>
}