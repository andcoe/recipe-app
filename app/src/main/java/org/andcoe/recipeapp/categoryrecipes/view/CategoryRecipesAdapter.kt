package org.andcoe.recipeapp.categoryrecipes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_category_item.view.*
import kotlinx.android.synthetic.main.view_category_recipe_item.view.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categories.view.CategoryListAdapter
import org.andcoe.recipeapp.categoryrecipes.model.RecipeItem

class CategoryRecipesAdapter(private val itemSelectedListener: (RecipeItem) -> Unit)
    : RecyclerView.Adapter<CategoryRecipesAdapter.CategoryRecipeViewHolder>() {

    private var items: List<RecipeItem> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryRecipeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_category_recipe_item, parent, false)
        return CategoryRecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryRecipeViewHolder, position: Int) {
        val current = items[position]
        holder.title.text = current.name
        holder.itemView.setOnClickListener { itemSelectedListener.invoke(current) }
    }

    fun setRecipes(items: List<RecipeItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class CategoryRecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val title: TextView = itemView.recipeName
    }
}
