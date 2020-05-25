package org.andcoe.recipeapp.recipe.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import org.andcoe.recipeapp.repository.RecipeRepository
import org.andcoe.recipeapp.repository.api.RecipeResponse

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {

    fun recipe(id: String): LiveData<Recipe> =
        LiveDataReactiveStreams.fromPublisher(
            repository
                .getRecipe(id)
                .map { toUiDataModel(it) }
                .subscribeOn(Schedulers.io())
                .toFlowable()
        )

    private fun toUiDataModel(it: RecipeResponse) =
        Recipe(name = it.meals[0].strMeal, instructions = it.meals[0].strInstructions)

}