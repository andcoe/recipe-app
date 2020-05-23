package org.andcoe.recipeapp.categories.repository

import io.reactivex.Maybe
import io.reactivex.Single
import org.andcoe.recipeapp.categories.repository.network.CategoryListResponse
import org.andcoe.recipeapp.categories.repository.network.TheMealDbApiClient
import org.andcoe.recipeapp.categories.repository.storage.CategoryListLocalStore
import timber.log.Timber

class CategoryRepository(private val categoryListLocalStore: CategoryListLocalStore,
                         private val theMealDbApiClient: TheMealDbApiClient) {

    fun getListCategories(): Single<CategoryListResponse> =
        fromLocalStore()
            .switchIfEmpty(
                fromApi()
                    .map {
                        categoryListLocalStore.store(it)
                        it
                    }
            )

    private fun fromApi(): Single<CategoryListResponse> {
        Timber.d("fromApi")
        return theMealDbApiClient.getListCategories()
    }

    private fun fromLocalStore(): Maybe<CategoryListResponse> {
        Timber.d("fromLocalStore")
        return categoryListLocalStore.categoryList()
    }

}