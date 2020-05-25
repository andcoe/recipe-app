package org.andcoe.recipeapp.recipe.view

import android.content.Context
import android.widget.ArrayAdapter
import java.util.*

internal class StableArrayAdapter(
    context: Context,
    textViewResourceId: Int,
    items: List<String>
) : ArrayAdapter<String>(context, textViewResourceId, items)