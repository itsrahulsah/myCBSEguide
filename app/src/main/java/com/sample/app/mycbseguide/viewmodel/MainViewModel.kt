package com.sample.app.mycbseguide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.app.mycbseguide.models.CategoryModel
import com.sample.app.mycbseguide.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val categoryRepository: CategoryRepository) :ViewModel(){

    val categoryList:LiveData<List<CategoryModel>>
    get() = categoryRepository.categoriesList

    val somethingWentWrong:LiveData<Unit>
    get() = categoryRepository.somethingWentWrong

    fun getAllCategories(){
        viewModelScope.launch (Dispatchers.IO){
            categoryRepository.getAllCategories()
        }
    }
}

