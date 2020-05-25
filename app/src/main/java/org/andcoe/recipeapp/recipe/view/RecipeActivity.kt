package org.andcoe.recipeapp.recipe.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_recipe.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categoryrecipes.model.CategoryRecipeItem
import org.andcoe.recipeapp.core.appModule
import org.andcoe.recipeapp.recipe.model.Recipe
import timber.log.Timber


class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        setTitle()
        setRecipeImage()
        registerObservers()
    }

    private fun setTitle() {
        supportActionBar?.title = getString(R.string.recipe_title, recipeName())
    }

    private fun setRecipeImage() {
        Glide
            .with(this)
            .load(recipeImageUrl())
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(recipeImage)
    }

    private fun registerObservers() {
        appModule()
            .recipeViewModel(this)
            .recipe(recipeId())
            .observe(this, Observer {
                setRecipeDetail(it)
            })
    }

    private fun setRecipeDetail(recipe: Recipe) {
        recipeInstructions.text = recipe.instructions

        recipe.ingredients.forEach {
            Timber.d("Recipe ing: $it")

            val ingredientView = IngredientView(this, null)
            ingredientView.setIngredient(it)
            ingredientsContainer.addView(ingredientView)
        }
    }

    private fun recipeId(): String = intent.getStringExtra(recipeIdKey)!! // TODO: show error
    private fun recipeName(): String = intent.getStringExtra(recipeNameKey)!! // TODO: show error
    private fun recipeImageUrl(): String =
        intent.getStringExtra(recipeImageUrl)!! // TODO: show error

    companion object {
        private const val recipeIdKey = "recipe_id_key"
        private const val recipeNameKey = "recipe_name_key"
        private const val recipeImageUrl = "recipe_image_key"

        fun start(context: Context, categoryRecipeItem: CategoryRecipeItem) {
            val intent = createStartIntent(context, categoryRecipeItem)
            context.startActivity(intent)
        }

        fun createStartIntent(context: Context, categoryRecipeItem: CategoryRecipeItem): Intent {
            val intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra(recipeIdKey, categoryRecipeItem.id)
            intent.putExtra(recipeNameKey, categoryRecipeItem.name)
            intent.putExtra(recipeImageUrl, categoryRecipeItem.imageUrl)
            return intent
        }
    }
}
