package com.sample.app.mycbseguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sample.app.mycbseguide.adpters.CategoryAdapter
import com.sample.app.mycbseguide.database.AppDatabase
import com.sample.app.mycbseguide.repository.CategoryRepository
import com.sample.app.mycbseguide.viewmodel.MainViewModel
import com.sample.app.mycbseguide.viewmodel.MainViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter:CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this,
            MainViewModelProvider(CategoryRepository(AppDatabase.getDatabase(this)))
        )[MainViewModel::class.java]
        init()

    }

    private fun init(){
        viewModel.getAllCategories()
        adapter = CategoryAdapter {  }
        viewModel.categoryList.observe(this){

        }
    }
}