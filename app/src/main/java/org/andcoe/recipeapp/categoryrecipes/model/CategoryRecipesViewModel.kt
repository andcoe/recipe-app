package org.andcoe.recipeapp.categoryrecipes.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import org.andcoe.recipeapp.repository.RecipeRepository
import org.andcoe.recipeapp.repository.api.CategoryRecipesResponse

class CategoryRecipesViewModel(private val repository: RecipeRepository) : ViewModel() {

    fun categoryRecipes(category: String): LiveData<List<RecipeItem>> =
        LiveDataReactiveStreams.fromPublisher(
            repository
                .getCategoryRecipes(category)
                .map { toUiDataModel(it) }
                .subscribeOn(Schedulers.io())
                .toFlowable()
        )

    private fun toUiDataModel(it: CategoryRecipesResponse) =
        it.meals.map { m -> RecipeItem(name = m.strMeal, imageUrl = m.strMealThumb) }

}