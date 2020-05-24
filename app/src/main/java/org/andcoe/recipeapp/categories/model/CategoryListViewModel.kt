package org.andcoe.recipeapp.categories.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import org.andcoe.recipeapp.repository.RecipeRepository
import org.andcoe.recipeapp.repository.api.CategoryListResponse

class CategoryListViewModel(private val repository: RecipeRepository) : ViewModel() {

    fun categoryList(): LiveData<List<CategoryItem>> =
        LiveDataReactiveStreams.fromPublisher(
            repository
                .getCategories()
                .map { toUiDataModel(it) }
                .subscribeOn(Schedulers.io())
                .toFlowable()
        )

    private fun toUiDataModel(it: CategoryListResponse) =
        it.meals.map { m -> CategoryItem(m.strCategory) }

}