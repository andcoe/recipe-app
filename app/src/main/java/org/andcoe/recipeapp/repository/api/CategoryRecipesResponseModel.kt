package org.andcoe.recipeapp.repository.api

data class CategoryRecipesResponse(val meals: List<Recipe>)
data class Recipe(val idMeal: String, val strMeal: String, val strMealThumb: String)
