package com.im.cookgaloreapp.data.remote.recipe

import com.google.gson.annotations.SerializedName

data class RecipesNetworkResponse(

    @SerializedName(value =  "count")
    val count: Int? = null,

    @SerializedName(value = "next")
    val next: String? = null,

    @SerializedName(value =  "previous")
    val previous: String? = null,

    @SerializedName(value = "results")
    val recipes: List<RecipesNetworkEntity> = listOf()

)