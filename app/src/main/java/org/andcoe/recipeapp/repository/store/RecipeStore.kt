package org.andcoe.recipeapp.repository.store

import io.reactivex.Maybe
import org.andcoe.recipeapp.repository.api.CategoryListResponse
import org.andcoe.recipeapp.repository.api.CategoryRecipesResponse
import org.andcoe.recipeapp.repository.api.RecipeResponse
import timber.log.Timber

class RecipeStore {

    private var categoryListResponse: CategoryListResponse? = null

    fun categoryList(): Maybe<CategoryListResponse> = when {
        categoryListResponse != null -> Maybe.just(categoryListResponse)
        else -> Maybe.empty()
    }

    fun storeCategoryRecipes(categoryListResponse: CategoryListResponse) {
        Timber.d("storing: $categoryListResponse")
        this.categoryListResponse = categoryListResponse
    }

    private val categoryRecipesCache = mutableMapOf<String, CategoryRecipesResponse>()

    fun getCategoryRecipes(category: String): Maybe<CategoryRecipesResponse> = when {
        categoryRecipesCache[category] != null -> Maybe.just(categoryRecipesCache[category])
        else -> Maybe.empty()
    }

    fun storeCategoryRecipes(category: String, response: CategoryRecipesResponse) {
        Timber.d("storing: $category -> $response")
        categoryRecipesCache[category] = response
    }

    private val recipeCache = mutableMapOf<String, RecipeResponse>()

    fun getRecipe(id: String): Maybe<RecipeResponse> = when {
        recipeCache[id] != null -> Maybe.just(recipeCache[id])
        else -> Maybe.empty()
    }

    fun storeRecipe(id: String, response: RecipeResponse) {
        Timber.d("storing: recipe: $id -> $response")
        recipeCache[id] = response
    }

}