package com.sample.app.mycbseguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.app.mycbseguide.adpters.ChildCategoryAdapter
import com.sample.app.mycbseguide.database.AppDatabase
import com.sample.app.mycbseguide.databinding.ActivityChildCategoryBinding
import com.sample.app.mycbseguide.repository.CategoryRepository
import com.sample.app.mycbseguide.utils.Constraints
import com.sample.app.mycbseguide.viewmodel.ChildCategoryViewModel
import com.sample.app.mycbseguide.viewmodel.ChildCategoryViewModelProvider

class ChildCategoryActivity : AppCompatActivity() {
    private lateinit var viewModel:ChildCategoryViewModel
   private lateinit var adapter:ChildCategoryAdapter
   private lateinit var binding:ActivityChildCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,ChildCategoryViewModelProvider(
            CategoryRepository(
                AppDatabase.getDatabase(this))
        ))[ChildCategoryViewModel::class.java]
        init()
    }

    private fun init(){
        val parentId = intent.getIntExtra(Constraints.PARENT_ID,0)
        val categoryName = intent.getStringExtra(Constraints.CATEGORY_NAME)
        binding.headerText.text = categoryName

            if (parentId != 0) {
                viewModel.getCategoryChildren(parentId)
            }

        adapter = ChildCategoryAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        binding.recyclerView.adapter = adapter

        viewModel.childCategoryList.observe(this){
            adapter.setCategoriesList(it)
        }
        binding.backArrow.setOnClickListener{
            finish()
        }

    }
}