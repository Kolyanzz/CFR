package com.kolumbo.chinesefoodrecipes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Класс БД
 *
 * @author Egor Ponomarev
 */
@Database(entities = [Recipe::class], version = 1)
abstract class RecipesDatabase: RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
    /**
     * Реализуем паттерн Singleton
     */
    companion object {
        @Volatile
        private var INSTANCE: RecipesDatabase? = null

        fun get(_context: Context): RecipesDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    _context.applicationContext,
                    RecipesDatabase::class.java,
                    "recipe-database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}