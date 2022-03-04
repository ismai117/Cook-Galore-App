package com.im.cookgaloreapp.repository.recipe

import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun searchRecipes(
        auth: String,
        page: Int,
        query: String
    ) : List<Recipes>

    fun getRecipes(): Flow<List<Recipes>>

    fun ifRecipesExists(recipe: Int): Flow<Int>

    suspend fun insertRecipes(recipes: Recipes)

    suspend fun deleteRecipes(recipes: Recipes)


}