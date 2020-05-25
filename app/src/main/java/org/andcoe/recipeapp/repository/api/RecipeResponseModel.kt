package org.andcoe.recipeapp.repository.api

data class RecipeResponse(val meals: List<RecipeDetail>)
data class RecipeDetail(
    val strMeal: String,
    val strInstructions: String
)
