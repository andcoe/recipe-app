package org.andcoe.recipeapp.categories.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_category_item.view.*
import org.andcoe.recipeapp.R

class CategoryListAdapter(private val categorySelectedListener: (CategoryItem) -> Unit)
    : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    private var categoryList: List<CategoryItem> = mutableListOf()

    override fun getItemCount(): Int = categoryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_category_item, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current = categoryList[position]
        holder.title.text = current.title
        holder.itemView.setOnClickListener { categorySelectedListener.invoke(current) }
    }

    internal fun setCategories(categories: List<CategoryItem>) {
        categoryList = categories
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val title: TextView = itemView.title
    }
}
