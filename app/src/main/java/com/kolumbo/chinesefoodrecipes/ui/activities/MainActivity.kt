package com.kolumbo.chinesefoodrecipes.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kolumbo.chinesefoodrecipes.R
import androidx.work.ListenableWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.kolumbo.chinesefoodrecipes.database.Recipe
import com.kolumbo.chinesefoodrecipes.database.RecipesDatabase
import com.kolumbo.chinesefoodrecipes.databinding.ActivityMainBinding
import com.kolumbo.chinesefoodrecipes.helper.Constants
import com.kolumbo.chinesefoodrecipes.helper.Helper
import com.kolumbo.chinesefoodrecipes.models.RecipeFirestore
import com.kolumbo.chinesefoodrecipes.viewmodel.RecipeViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mViewModel: RecipeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Helper.isConnected(this)) {
            startParseWorkManager()
        }
    }

    private fun startParseWorkManager() {
        val lastParsedDay =
            Helper.getSharedPreferences(
                Constants.LAST_PARSED_DAY_KEY,
                ""
            ) // палучаем последнию дату когда был парсинг
        var day = 0
        var month = 0
        if (lastParsedDay.isNotEmpty()) {
            day = lastParsedDay.split("/")[0].toInt()
            month = lastParsedDay.split("/")[1].toInt()
        }
        val currentDate = SimpleDateFormat("dd/MM").format(Date()).split("/")
        val currentDay = currentDate[0].toInt()
        val currentMonth = currentDate[1].toInt()

        // проверка если последня дата парсинга была вчера или еще раньще
        if (day < currentDay && currentMonth >= month) {
            val fireStore = FirebaseFirestore.getInstance()
            val recipesDao = RecipesDatabase.get(this).recipesDao()

            fireStore.collection("recipes")
                .get()
                .addOnSuccessListener {
                    val recipes = it.toObjects(RecipeFirestore::class.java)
                    if (recipes.isNotEmpty()) {
                        GlobalScope.launch(Dispatchers.IO) {
                            // удаляем все из локальной базы
                            recipesDao.deleteAll()
                            recipes.map { r ->
                                recipesDao.insertRecipe(
                                    Recipe(
                                        recipeName = r.recipeName,
                                        recipeDescription = r.recipeDescription,
                                        foodPicturePath = r.foodPicturePath,
                                        recipeRating = r.recipeRating,
                                        isFavorite = false,
                                        categoryName = r.categoryName
                                    )
                                )
                            }
                            Helper.putSharedPreferences(
                                Constants.LAST_PARSED_DAY_KEY,
                                currentDate.joinToString("/")
                            )
                        }
                    }
                }
        }
    }

}