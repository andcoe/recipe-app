package org.andcoe.recipeapp.repository

import io.reactivex.Maybe
import io.reactivex.Single
import org.andcoe.recipeapp.repository.api.CategoryListResponse
import org.andcoe.recipeapp.repository.api.CategoryRecipesResponse
import org.andcoe.recipeapp.repository.api.TheMealDbApiClient
import org.andcoe.recipeapp.repository.store.RecipeStore
import timber.log.Timber

class RecipeRepository(private val store: RecipeStore,
                       private val apiClient: TheMealDbApiClient) {

    fun getCategories(): Single<CategoryListResponse> =
        categoriesFromLocalStore()
            .switchIfEmpty(
                categoriesFromApi()
                    .map {
                        store.store(it)
                        it
                    }
            )

    private fun categoriesFromApi(): Single<CategoryListResponse> {
        Timber.d("categoriesFromApi")
        return apiClient.getListCategories()
    }

    private fun categoriesFromLocalStore(): Maybe<CategoryListResponse> {
        Timber.d("categoriesFromLocalStore")
        return store.categoryList()
    }

    fun getCategoryRecipes(category: String): Single<CategoryRecipesResponse> =
        categoryRecipesFromLocalStore(category)
            .switchIfEmpty(
                categoryRecipesFromApi(category)
                    .map {
                        store.store(category, it)
                        it
                    }
            )

    private fun categoryRecipesFromApi(category: String): Single<CategoryRecipesResponse> {
        Timber.d("categoryRecipesFromApi")
        return apiClient.getCategoryRecipes(category)
    }

    private fun categoryRecipesFromLocalStore(category: String): Maybe<CategoryRecipesResponse> {
        Timber.d("categoryRecipesFromLocalStore")
        return store.getCategoryRecipes(category)
    }

}