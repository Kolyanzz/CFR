package com.kolumbo.chinesefoodrecipes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
@Entity(tableName = "recipesTable")
data class Recipe (
    @PrimaryKey(autoGenerate = true)
    val mId: Int,

    @ColumnInfo(name = "mRecipeName")
    var mRecipeName: String,
    @ColumnInfo(name = "mRecipeDescription")
    var mRecipeDescription: String,
    @ColumnInfo(name = "mFoodPicturePath")
    var mFoodPicturePath: String?,
    @ColumnInfo(name = "mRecipeRating")
    var mRecipeRating: Int,
    @ColumnInfo(name = "mIsFavorite")
    var mIsFavorite: Boolean,
    @ColumnInfo(name = "mCategoryName")
    var mCategoryName: String
)