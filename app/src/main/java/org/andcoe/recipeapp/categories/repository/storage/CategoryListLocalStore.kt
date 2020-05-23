package org.andcoe.recipeapp.categories.repository.storage

import io.reactivex.Maybe
import org.andcoe.recipeapp.categories.repository.network.CategoryListResponse
import timber.log.Timber

class CategoryListLocalStore {

    private var categoryListResponse: CategoryListResponse? = null

    fun categoryList(): Maybe<CategoryListResponse> = when {
        categoryListResponse != null -> Maybe.just(categoryListResponse)
        else -> Maybe.empty()
    }

    fun store(categoryListResponse: CategoryListResponse) {
        Timber.d("storing: $categoryListResponse")
        this.categoryListResponse = categoryListResponse
    }

}