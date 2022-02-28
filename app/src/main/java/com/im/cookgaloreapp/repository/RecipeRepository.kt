package com.im.cookgaloreapp.repository

import com.im.cookgaloreapp.domain.Recipes.Recipes

interface RecipeRepository {


    suspend fun searchRecipes(
        auth: String,
        page: Int,
        query: String
    ) : List<Recipes>


}