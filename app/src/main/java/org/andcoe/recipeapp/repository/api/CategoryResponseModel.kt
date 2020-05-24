package org.andcoe.recipeapp.repository.api

data class CategoryListResponse(val meals: List<Category>)
data class Category(val strCategory: String)
