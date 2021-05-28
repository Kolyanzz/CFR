package com.kolumbo.chinesefoodrecipes.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kolumbo.chinesefoodrecipes.R
import com.kolumbo.chinesefoodrecipes.database.Recipe

class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var mNameRecipeView: TextView = itemView.findViewById(R.id.recipe_name)

    fun bind(_recipe: Recipe) {
        mNameRecipeView.text = _recipe.mRecipeName
    }
}