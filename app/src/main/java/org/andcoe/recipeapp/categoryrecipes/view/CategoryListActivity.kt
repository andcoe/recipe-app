package org.andcoe.recipeapp.categoryrecipes.view;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_category_recipes.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categories.view.CategoryItem

class CategoryRecipesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_recipes)

        supportActionBar?.title = getString(R.string.category_recipes_title)

        categoryName.text = intent.getStringExtra(categoryKey)
    }

    companion object {
        const val categoryKey = "category_key"

        fun start(context: Context, categoryItem: CategoryItem) {
            val intent = Intent(context, CategoryRecipesActivity::class.java)
            intent.putExtra(categoryKey, categoryItem.title)
            context.startActivity(intent)
        }
    }
}