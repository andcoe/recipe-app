package org.andcoe.recipeapp.categoryrecipes.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category_recipes.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categories.model.CategoryItem
import org.andcoe.recipeapp.core.appModule
import org.andcoe.recipeapp.recipe.view.RecipeActivity

class CategoryRecipesActivity : AppCompatActivity() {

    private lateinit var listAdapter: CategoryRecipesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_recipes)
        setTitle()
        setRecyclerView()
        registerObservers()
    }

    private fun setTitle() {
        supportActionBar?.title = getString(R.string.category_recipes_title, categoryName())
    }

    private fun setRecyclerView() {
        listAdapter = CategoryRecipesAdapter {
            RecipeActivity.start(this, it)
        }
        categoryRecipesList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CategoryRecipesActivity)
            adapter = listAdapter
        }
    }

    private fun registerObservers() {
        appModule()
            .categoryRecipesViewModel(this)
            .categoryRecipes(categoryName())
            .observe(this, Observer { listAdapter.setRecipes(it) })
    }

    private fun categoryName(): String = intent.getStringExtra(categoryKey)!! // TODO: show error

    companion object {
        private const val categoryKey = "category_key"

        fun start(context: Context, categoryItem: CategoryItem) {
            val intent = createStartIntent(context, categoryItem)
            context.startActivity(intent)
        }

        fun createStartIntent(context: Context, categoryItem: CategoryItem): Intent {
            val intent = Intent(context, CategoryRecipesActivity::class.java)
            intent.putExtra(categoryKey, categoryItem.title)
            return intent
        }
    }
}