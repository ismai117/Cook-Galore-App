package com.im.cookgaloreapp.repository

import com.im.cookgaloreapp.data.remote.service.RecipeService
import com.im.cookgaloreapp.data.remote.util.RecipesResponseMapper
import com.im.cookgaloreapp.domain.Recipes.Recipes
import javax.inject.Inject

class RecipeRepository_Impl
@Inject
constructor(
    val recipeService: RecipeService,
    val responseMapper: RecipesResponseMapper
) : RecipeRepository{

    override suspend fun searchRecipes(auth: String, page: Int, query: String): List<Recipes> {
        val response = recipeService.getRecipes(auth, page, query).recipes
        return responseMapper.mapFromEntityList(response)
    }

}