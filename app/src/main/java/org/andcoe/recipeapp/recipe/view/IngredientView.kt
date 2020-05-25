package org.andcoe.recipeapp.recipe.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.view_ingredient_item.view.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.recipe.model.Ingredient

class IngredientView(context: Context, attributeSet: AttributeSet?) :
    ConstraintLayout(context, attributeSet) {

    init {
        inflate(context, R.layout.view_ingredient_item, this)
    }

    fun setIngredient(ingredient: Ingredient) {
        ingredientQuantity.text = ingredient.quantity
        ingredientName.text = ingredient.name
    }
}