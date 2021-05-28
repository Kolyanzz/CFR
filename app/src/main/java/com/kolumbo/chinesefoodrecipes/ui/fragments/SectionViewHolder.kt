package com.kolumbo.chinesefoodrecipes.ui.fragments

import android.view.View
import com.kolumbo.chinesefoodrecipes.models.SectionRecipes
import com.kolumbo.chinesefoodrecipes.ui.base.BaseRecyclerViewAdapter
import com.kolumbo.chinesefoodrecipes.ui.base.BaseViewHolder

class SectionViewHolder(itemView: View, listener: BaseRecyclerViewAdapter.OnItemClickListener<SectionRecipes>? = null) : BaseViewHolder<SectionRecipes>(itemView, listener) {

    override fun bind(item: SectionRecipes) {
        super.bind(item)
    }

}