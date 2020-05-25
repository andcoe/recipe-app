package org.andcoe.recipeapp.recipe.model

data class Recipe(val name: String, val ingredients: List<Ingredient>, val instructions: String)
data class Ingredient(val name: String, val quantity: String)