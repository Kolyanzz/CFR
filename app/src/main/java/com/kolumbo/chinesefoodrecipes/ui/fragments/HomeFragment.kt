package com.kolumbo.chinesefoodrecipes.ui.fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kolumbo.chinesefoodrecipes.R
import com.kolumbo.chinesefoodrecipes.database.Recipe
import com.kolumbo.chinesefoodrecipes.databinding.FragmentHomeBinding
import com.kolumbo.chinesefoodrecipes.models.SectionRecipes
import com.kolumbo.chinesefoodrecipes.ui.activities.MainActivity
import com.kolumbo.chinesefoodrecipes.ui.base.BaseRecyclerViewAdapter
class HomeFragment : Fragment() {



    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var recipesAdapter: BaseRecyclerViewAdapter<SectionRecipes>
    private var sectionRecipes = arrayListOf<SectionRecipes>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity() as MainActivity)[HomeViewModel::class.java]
        recipesAdapter = BaseRecyclerViewAdapter(R.layout.recipe_section_item)
        binding.mainRecyclerView.apply {
            adapter = recipesAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        viewModel.getSectionRecipes().observe(viewLifecycleOwner, {
            sectionRecipes.clear()
            sectionRecipes.addAll(it)
            recipesAdapter.setItems(sectionRecipes)
        })
    }
}