package com.kolumbo.chinesefoodrecipes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kolumbo.chinesefoodrecipes.R
import com.kolumbo.chinesefoodrecipes.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var mBinding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search, container, false
        )
        return mBinding.root
    }
}