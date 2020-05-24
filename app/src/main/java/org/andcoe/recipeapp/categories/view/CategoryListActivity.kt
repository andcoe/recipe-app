package org.andcoe.recipeapp.categories.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categoryrecipes.view.CategoryRecipesActivity
import org.andcoe.recipeapp.core.appModule

class CategoryListActivity : AppCompatActivity() {

    private lateinit var listAdapter: CategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setTitle()
        setRecyclerView()
        registerObservers()
    }

    private fun setTitle() {
        supportActionBar?.title = getString(R.string.category_list_title)
    }

    private fun setRecyclerView() {
        listAdapter = CategoryListAdapter {
            CategoryRecipesActivity.start(this, it)
        }
        categoryList.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(this@CategoryListActivity, LinearLayout.VERTICAL))
            layoutManager = LinearLayoutManager(this@CategoryListActivity)
            adapter = listAdapter
        }
    }

    private fun registerObservers() {
        appModule()
            .categoryListViewModel(this)
            .categoryList()
            .observe(this, Observer { listAdapter.setCategories(it) })
    }
}
