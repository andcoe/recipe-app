package org.andcoe.recipeapp.recipe.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.andcoe.recipeapp.repository.RecipeRepository

class RecipeViewModelFactory(private val recipeRepository: RecipeRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        RecipeViewModel(recipeRepository) as T
}