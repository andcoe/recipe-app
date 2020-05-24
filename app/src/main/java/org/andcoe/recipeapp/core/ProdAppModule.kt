package org.andcoe.recipeapp.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.andcoe.recipeapp.repository.RecipeRepository
import org.andcoe.recipeapp.repository.api.TheMealDbApiClient
import org.andcoe.recipeapp.repository.store.RecipeStore
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import timber.log.Timber

class ProdAppModule : AppModule() {

    private val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.tag("OkHttp").d(message)
        }
    }).setLevel(HttpLoggingInterceptor.Level.BASIC)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    override val theMealDbApiClient: TheMealDbApiClient = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .client(okHttpClient)
        .addConverterFactory(JacksonConverterFactory.create(jacksonMapper))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(TheMealDbApiClient::class.java)

    override val recipeStore =
        RecipeStore()

    override val recipeRepository =
        RecipeRepository(
            store = recipeStore,
            apiClient = theMealDbApiClient
        )
}