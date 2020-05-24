package org.andcoe.recipeapp.repository.store

import io.reactivex.Maybe
import org.andcoe.recipeapp.repository.api.CategoryListResponse
import org.andcoe.recipeapp.repository.api.CategoryRecipesResponse
import timber.log.Timber

class RecipeStore {

    private var categoryListResponse: CategoryListResponse? = null

    fun categoryList(): Maybe<CategoryListResponse> = when {
        categoryListResponse != null -> Maybe.just(categoryListResponse)
        else -> Maybe.empty()
    }

    fun store(categoryListResponse: CategoryListResponse) {
        Timber.d("storing: $categoryListResponse")
        this.categoryListResponse = categoryListResponse
    }

    private val cache = mutableMapOf<String, CategoryRecipesResponse>()

    fun getCategoryRecipes(category: String): Maybe<CategoryRecipesResponse> = when {
        cache[category] != null -> Maybe.just(cache[category])
        else -> Maybe.empty()
    }

    fun store(category: String, response: CategoryRecipesResponse) {
        Timber.d("storing: $category -> $response")
        cache[category] = response
    }
}