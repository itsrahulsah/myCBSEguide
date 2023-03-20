package com.sample.app.mycbseguide

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.app.mycbseguide.adpters.CategoryAdapter
import com.sample.app.mycbseguide.database.AppDatabase
import com.sample.app.mycbseguide.databinding.ActivityMainBinding
import com.sample.app.mycbseguide.repository.CategoryRepository
import com.sample.app.mycbseguide.utils.Constraints
import com.sample.app.mycbseguide.viewmodel.MainViewModel
import com.sample.app.mycbseguide.viewmodel.MainViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter:CategoryAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,
            MainViewModelProvider(CategoryRepository(AppDatabase.getDatabase(this)))
        )[MainViewModel::class.java]
        init()

    }

    private fun init(){
        viewModel.getAllCategories()
        adapter = CategoryAdapter {
            Log.e("TAG",it.toString())
            val intent = Intent(this,ChildCategoryActivity::class.java)
            intent.putExtra(Constraints.CATEGORY_NAME,it.name)
            intent.putExtra(Constraints.PARENT_ID,it.id)
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        binding.recyclerView.adapter = adapter

        viewModel.categoryList.observe(this){

            adapter.setCategoriesList(it)
        }

        viewModel.somethingWentWrong.observe(this){
            Toast.makeText(this,"something went wrong please try again....",Toast.LENGTH_LONG).show()
        }
    }
}