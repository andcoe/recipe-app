package org.andcoe.recipeapp.categories.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import org.andcoe.recipeapp.categories.repository.CategoryRepository
import org.andcoe.recipeapp.categories.repository.network.CategoryListResponse
import org.andcoe.recipeapp.categories.view.CategoryItem

class CategoryListViewModel(private val repository: CategoryRepository) : ViewModel() {

    fun categoryList(): LiveData<List<CategoryItem>> =
        LiveDataReactiveStreams.fromPublisher(
            repository
                .getListCategories()
                .map { toUiDataModel(it) }
                .subscribeOn(Schedulers.io())
                .toFlowable()
        )

    private fun toUiDataModel(it: CategoryListResponse) =
        it.meals.map { m -> CategoryItem(m.strCategory) }

}