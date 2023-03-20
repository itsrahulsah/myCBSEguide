package com.sample.app.mycbseguide.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.app.mycbseguide.repository.CategoryRepository


class ChildCategoryViewModelProvider(private val categoryRepository: CategoryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return ChildCategoryViewModel(categoryRepository) as T
    }
}