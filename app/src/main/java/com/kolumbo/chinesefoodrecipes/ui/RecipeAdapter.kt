package com.kolumbo.chinesefoodrecipes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kolumbo.chinesefoodrecipes.R
import com.kolumbo.chinesefoodrecipes.database.Recipe

class RecipeAdapter(_listOfRecipes: List<Recipe>): RecyclerView.Adapter<RecipeViewHolder>() {
    private val mListOfRecipes = _listOfRecipes

    override fun onCreateViewHolder(_parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(_parent.context).inflate(R.layout.recipe_item,
            _parent, false)

        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(_holder: RecipeViewHolder, _position: Int) {
        _holder.bind(mListOfRecipes[_position])
    }

    override fun getItemCount() = mListOfRecipes.size
}