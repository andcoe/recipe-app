package org.andcoe.recipeapp.categoryrecipes.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.andcoe.recipeapp.categories.model.CategoryListViewModel
import org.andcoe.recipeapp.repository.RecipeRepository

class CategoryRecipesViewModelFactory(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        CategoryRecipesViewModel(recipeRepository) as T
}