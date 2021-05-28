package com.kolumbo.chinesefoodrecipes.database

/**
 * Класс сущности в БД
 * @see RecipesDatabase
 *
 * @property mId Поле для хранения ID рецепта для последующего доступа к нему
 * @property mRecipeName Поле для хранения имени рецепта
 * @property mRecipeDescription Поле с описанием рецепта
 * @property mRecipeRating Поле с рейтенигом рецепта
 * @property mIsFavorite Хранит информацию об статусе рецепта в избранном
 *
 * @author Egor Ponomarev
 */
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "recipesTable")
data class Recipe (
    @PrimaryKey(autoGenerate = true)
    val mId: Int,
    class Recipe {

    @PrimaryKey(autoGenerate = true)
    var mId: Int? = null
    @ColumnInfo(name = "mRecipeName")
    var mRecipeName: String,
    var recipeName: String = ""
    @ColumnInfo(name = "mRecipeDescription")
    var mRecipeDescription: String,
    var recipeDescription: String = ""
    @ColumnInfo(name = "mFoodPicturePath")
    var mFoodPicturePath: String?,
    var foodPicturePath: String? = ""
    @ColumnInfo(name = "mRecipeRating")
    var mRecipeRating: Int,
    var recipeRating: Int = 0
    @ColumnInfo(name = "mIsFavorite")
    var mIsFavorite: Boolean,
    var isFavorite: Boolean? = false
    @ColumnInfo(name = "mCategoryName")
    var mCategoryName: String
    )
    var categoryName: String? = ""

    constructor(
        mId: Int?,
        recipeName: String,
        recipeDescription: String,
        foodPicturePath: String?,
        recipeRating: Int,
        isFavorite: Boolean?,
        categoryName: String?
    ) {
        this.mId = mId
        this.recipeName = recipeName
        this.recipeDescription = recipeDescription
        this.foodPicturePath = foodPicturePath
        this.recipeRating = recipeRating
        this.isFavorite = isFavorite
        this.categoryName = categoryName
    }

    @Ignore
    constructor(
        recipeName: String,
        recipeDescription: String,
        foodPicturePath: String?,
        recipeRating: Int,
        isFavorite: Boolean?,
        categoryName: String?
    ) {
        this.recipeName = recipeName
        this.recipeDescription = recipeDescription
        this.foodPicturePath = foodPicturePath
        this.recipeRating = recipeRating
        this.isFavorite = isFavorite
        this.categoryName = categoryName
    }

}