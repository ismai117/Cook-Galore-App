package com.im.cookgaloreapp.data.remote.recipe

import com.google.gson.annotations.SerializedName


data class RecipesNetworkEntity(

    @SerializedName(value = "pk")
    val id: Int? = null,

    @SerializedName(value = "cooking_instructions")
    val cooking_instructions: String? = null,

    @SerializedName(value = "date_added")
    val date_added: String? = null,

    @SerializedName(value = "date_updated")
    val date_updated: String? = null,

    @SerializedName(value = "description")
    val description: String? = null,

    @SerializedName(value = "featured_image")
    val featured_image: String? = null,

    @SerializedName(value = "ingredients")
    val ingredients: List<String>? = null,

    @SerializedName(value = "long_date_added")
    val long_date_added: Int? = null,

    @SerializedName(value = "long_date_updated")
    val long_date_updated: Int? = null,

    @SerializedName(value = "publisher")
    val publisher: String? = null,

    @SerializedName(value = "rating")
    val rating: Int? = null,

    @SerializedName(value = "source_url")
    val source_url: String? = null,

    @SerializedName(value = "title")
    val title: String? = null,

)