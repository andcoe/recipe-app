package org.andcoe.recipeapp.categories.repository.network

import io.reactivex.Single
import retrofit2.http.GET

interface TheMealDbApiClient {

    @GET("list.php?c=list")
    fun getListCategories(): Single<CategoryListResponse>

}
