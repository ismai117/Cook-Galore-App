package com.im.cookgaloreapp.data.local.recipe

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")
class RecipesCacheEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val cooking_instructions: String? = null,
    val date_added: String? = null,
    val date_updated: String? = null,
    val description: String? = null,
    val featured_image: String? = null,
    val ingredients: List<String>? = null,
    val long_date_added: Int? = null,
    val long_date_updated: Int? = null,
    val publisher: String? = null,
    val rating: Int? = null,
    val source_url: String? = null,
    val title: String? = null

)