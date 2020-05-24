package org.andcoe.recipeapp.categories.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.andcoe.recipeapp.repository.RecipeRepository

class CategoryViewModelFactory(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        CategoryListViewModel(recipeRepository) as T
}