package org.andcoe.recipeapp.categories.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_category_item.view.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categories.model.CategoryItem

class CategoryListAdapter(private val categorySelectedListener: (CategoryItem) -> Unit)
    : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    private var items: List<CategoryItem> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_category_item, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current = items[position]
        holder.title.text = current.title
        holder.itemView.setOnClickListener { categorySelectedListener.invoke(current) }
    }

    internal fun setCategories(items: List<CategoryItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val title: TextView = itemView.title
    }
}
