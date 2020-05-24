package org.andcoe.espresso

import io.reactivex.Single
import org.andcoe.recipeapp.categories.repository.CategoryRepository
import org.andcoe.recipeapp.categories.repository.network.CategoryListResponse
import org.andcoe.recipeapp.categories.repository.network.RecipeCategory
import org.andcoe.recipeapp.categories.repository.network.TheMealDbApiClient
import org.andcoe.recipeapp.categories.repository.storage.CategoryListLocalStore
import org.andcoe.recipeapp.core.AppModule

class TestAppModule : AppModule() {

    override val categoryListLocalStore: CategoryListLocalStore = CategoryListLocalStore()

    override val theMealDbApiClient: TheMealDbApiClient = object : TheMealDbApiClient {
        override fun getListCategories(): Single<CategoryListResponse> {
            return Single.just(CategoryListResponse(listOf(RecipeCategory("Pasta"))))
        }
    }

    override val categoryRepository = CategoryRepository(
        categoryListLocalStore = categoryListLocalStore,
        theMealDbApiClient = theMealDbApiClient
    )
}
