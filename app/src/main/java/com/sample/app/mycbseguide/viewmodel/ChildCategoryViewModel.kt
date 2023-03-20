package com.sample.app.mycbseguide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.app.mycbseguide.models.CategoryChildren
import com.sample.app.mycbseguide.repository.CategoryRepository
import kotlinx.coroutines.launch

class ChildCategoryViewModel(private val categoryRepository: CategoryRepository):ViewModel() {

    val childCategoryList: LiveData<List<CategoryChildren>>
        get() = categoryRepository.childCategoriesList


    fun getCategoryChildren(parentId:Int){
        viewModelScope.launch {
            categoryRepository.getChildCategories(parentId)
        }
    }

}