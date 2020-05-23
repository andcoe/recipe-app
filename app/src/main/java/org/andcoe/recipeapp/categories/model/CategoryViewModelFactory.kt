package org.andcoe.recipeapp.categories.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.andcoe.recipeapp.categories.repository.CategoryRepository

class CategoryViewModelFactory(private val categoryRepository: CategoryRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        CategoryListViewModel(categoryRepository) as T
}