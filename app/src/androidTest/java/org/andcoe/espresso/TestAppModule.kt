package org.andcoe.espresso

import io.reactivex.Single
import org.andcoe.recipeapp.repository.RecipeRepository
import org.andcoe.recipeapp.repository.store.RecipeStore
import org.andcoe.recipeapp.core.AppModule
import org.andcoe.recipeapp.repository.api.*

class TestAppModule : AppModule() {

    override val recipeStore: RecipeStore =
        RecipeStore()

    override val theMealDbApiClient: TheMealDbApiClient = object : TheMealDbApiClient {
        override fun getListCategories(): Single<CategoryListResponse> =
            Single.just(CategoryListResponse(listOf(Category("Pasta"))))

        override fun getCategoryRecipes(category: String): Single<CategoryRecipesResponse> =
            Single.just(
                CategoryRecipesResponse(
                    listOf(
                        Recipe(
                            idMeal = "1",
                            strMeal = "Tomato and pesto spaghetti",
                            strMealThumb = "some url"
                        )
                    )
                )
            )
    }

    override val recipeRepository =
        RecipeRepository(
            store = recipeStore,
            apiClient = theMealDbApiClient
        )
}
