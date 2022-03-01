package com.im.cookgaloreapp.repository

import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {


    suspend fun searchRecipes(
        auth: String,
        page: Int,
        query: String
    ) : List<Recipes>

    fun getRecipes(): Flow<List<Recipes>>

    fun ifExists(recipe: Int): Flow<Int>

    suspend fun insert(recipes: Recipes)

    suspend fun delete(recipes: Recipes)

}