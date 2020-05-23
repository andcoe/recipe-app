package org.andcoe.recipeapp.core

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.andcoe.recipeapp.categories.model.CategoryListViewModel
import org.andcoe.recipeapp.categories.model.CategoryViewModelFactory
import org.andcoe.recipeapp.categories.repository.CategoryRepository
import org.andcoe.recipeapp.categories.repository.network.TheMealDbApiClient
import org.andcoe.recipeapp.categories.repository.storage.CategoryListLocalStore

abstract class AppModule {

    val jacksonMapper: ObjectMapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    abstract val theMealDbApiClient: TheMealDbApiClient
    abstract val categoryListLocalStore: CategoryListLocalStore
    abstract val categoryRepository: CategoryRepository

    fun categoryListViewModel(owner: ViewModelStoreOwner): CategoryListViewModel =
        ViewModelProvider(owner, CategoryViewModelFactory(categoryRepository))
            .get(CategoryListViewModel::class.java)
}
