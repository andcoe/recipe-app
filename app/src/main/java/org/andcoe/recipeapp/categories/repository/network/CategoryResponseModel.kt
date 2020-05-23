package org.andcoe.recipeapp.categories.repository.network

data class CategoryListResponse(val meals: List<RecipeCategory>)
data class RecipeCategory(val strCategory: String)
