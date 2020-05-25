package org.andcoe.recipeapp.repository

import io.reactivex.Maybe
import io.reactivex.Single
import org.andcoe.recipeapp.repository.api.CategoryListResponse
import org.andcoe.recipeapp.repository.api.CategoryRecipesResponse
import org.andcoe.recipeapp.repository.api.RecipeResponse
import org.andcoe.recipeapp.repository.api.TheMealDbApiClient
import org.andcoe.recipeapp.repository.store.RecipeStore
import timber.log.Timber

class RecipeRepository(
    private val store: RecipeStore,
    private val apiClient: TheMealDbApiClient
) {

    fun getCategories(): Single<CategoryListResponse> =
        categoriesFromLocalStore()
            .switchIfEmpty(
                categoriesFromApi()
                    .map {
                        store.storeCategoryRecipes(it)
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
                        store.storeCategoryRecipes(category, it)
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

    fun getRecipe(id: String): Single<RecipeResponse> =
        recipeFromLocalStore(id)
            .switchIfEmpty(
                recipeFromApi(id)
                    .map {
                        store.storeRecipe(id, it)
                        it
                    }
            )

    private fun recipeFromApi(id: String): Single<RecipeResponse> {
        Timber.d("recipeFromApi")
        return apiClient.getRecipe(id)
    }

    private fun recipeFromLocalStore(id: String): Maybe<RecipeResponse> {
        Timber.d("recipeFromLocalStore")
        return store.getRecipe(id)
    }
}