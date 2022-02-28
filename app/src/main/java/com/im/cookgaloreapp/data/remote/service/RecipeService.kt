package com.im.cookgaloreapp.data.remote.service

import com.im.cookgaloreapp.data.remote.Recipe.RecipesNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("/api/recipe/search/")
    suspend fun getRecipes(
        @Header("Authorization") auth: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipesNetworkResponse

}

