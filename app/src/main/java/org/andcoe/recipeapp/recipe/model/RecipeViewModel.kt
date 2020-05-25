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

    private fun toUiDataModel(response: RecipeResponse) =
        Recipe(
            name = response.meals[0].strMeal,
            ingredients =
            listOf(
                Ingredient(
                    quantity = response.meals[0].strMeasure1.orEmpty(),
                    name = response.meals[0].strIngredient1.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure2.orEmpty(),
                    name = response.meals[0].strIngredient2.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure3.orEmpty(),
                    name = response.meals[0].strIngredient3.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure4.orEmpty(),
                    name = response.meals[0].strIngredient4.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure5.orEmpty(),
                    name = response.meals[0].strIngredient5.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure6.orEmpty(),
                    name = response.meals[0].strIngredient6.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure7.orEmpty(),
                    name = response.meals[0].strIngredient7.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure8.orEmpty(),
                    name = response.meals[0].strIngredient8.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure9.orEmpty(),
                    name = response.meals[0].strIngredient9.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure10.orEmpty(),
                    name = response.meals[0].strIngredient10.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure11.orEmpty(),
                    name = response.meals[0].strIngredient11.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure12.orEmpty(),
                    name = response.meals[0].strIngredient12.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure13.orEmpty(),
                    name = response.meals[0].strIngredient13.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure14.orEmpty(),
                    name = response.meals[0].strIngredient14.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure15.orEmpty(),
                    name = response.meals[0].strIngredient15.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure16.orEmpty(),
                    name = response.meals[0].strIngredient16.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure17.orEmpty(),
                    name = response.meals[0].strIngredient17.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure18.orEmpty(),
                    name = response.meals[0].strIngredient18.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure19.orEmpty(),
                    name = response.meals[0].strIngredient19.orEmpty()
                ),
                Ingredient(
                    quantity = response.meals[0].strMeasure20.orEmpty(),
                    name = response.meals[0].strIngredient20.orEmpty()
                )
            ).filter { it.name.isNotEmpty() },
            instructions = response.meals[0].strInstructions
        )

}