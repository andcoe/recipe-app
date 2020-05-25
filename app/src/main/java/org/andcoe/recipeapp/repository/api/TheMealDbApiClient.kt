package org.andcoe.recipeapp.repository.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealDbApiClient {

    @GET("list.php?c=list")
    fun getListCategories(): Single<CategoryListResponse>

    @GET("filter.php")
    fun getCategoryRecipes(@Query("c") category: String): Single<CategoryRecipesResponse>

    @GET("lookup.php")
    fun getRecipe(@Query("i") id: String): Single<RecipeResponse>

}
