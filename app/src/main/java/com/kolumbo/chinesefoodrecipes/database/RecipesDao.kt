package com.kolumbo.chinesefoodrecipes.database

/**
 * Интерфейс для общения с БД
 *
 * @author Egor Ponomarev
 */
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import androidx.room.*

@Dao
interface RecipesDao {
    @Update
    fun updateRecipe(vararg recipe: Recipe)
    @Query("SELECT * FROM recipesTable WHERE mId = :id")
    suspend fun getRecipeById(id: Int): Recipe

    @Query("SELECT * FROM recipesTable")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipesTable WHERE '%:q%'")
    fun searchRecipes(q: String): List<Recipe>

    @Insert
    fun insertRecipe(recipe: Recipe)

    @Query("DELETE FROM recipesTable")
    fun deleteAll()
}