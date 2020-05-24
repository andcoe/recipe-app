package org.andcoe.recipeapp.core

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.andcoe.recipeapp.categories.model.CategoryListViewModel
import org.andcoe.recipeapp.categories.model.CategoryViewModelFactory
import org.andcoe.recipeapp.repository.RecipeRepository
import org.andcoe.recipeapp.repository.api.TheMealDbApiClient
import org.andcoe.recipeapp.repository.store.RecipeStore
import org.andcoe.recipeapp.categoryrecipes.model.CategoryRecipesViewModel
import org.andcoe.recipeapp.categoryrecipes.model.CategoryRecipesViewModelFactory

abstract class AppModule {

    val jacksonMapper: ObjectMapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    abstract val theMealDbApiClient: TheMealDbApiClient
    abstract val recipeStore: RecipeStore
    abstract val recipeRepository: RecipeRepository

    fun categoryListViewModel(owner: ViewModelStoreOwner): CategoryListViewModel =
        ViewModelProvider(owner, CategoryViewModelFactory(recipeRepository))
            .get(CategoryListViewModel::class.java)

    fun categoryRecipesViewModel(owner: ViewModelStoreOwner): CategoryRecipesViewModel =
        ViewModelProvider(owner, CategoryRecipesViewModelFactory(recipeRepository))
            .get(CategoryRecipesViewModel::class.java)
}
