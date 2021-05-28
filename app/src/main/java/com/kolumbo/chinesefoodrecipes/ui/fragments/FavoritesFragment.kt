package com.kolumbo.chinesefoodrecipes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kolumbo.chinesefoodrecipes.R
import com.kolumbo.chinesefoodrecipes.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private lateinit var mBinding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_favorites, container, false)
        return mBinding.root
    }
}