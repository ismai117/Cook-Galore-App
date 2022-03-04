package com.im.cookgaloreapp.repository.recipe

import com.im.cookgaloreapp.data.local.favourites.FavouritesDao
import com.im.cookgaloreapp.data.local.recipe.RecipesDao
import com.im.cookgaloreapp.data.local.util.FavouritesCacheMapper
import com.im.cookgaloreapp.data.local.util.RecipesCacheMapper
import com.im.cookgaloreapp.data.remote.service.RecipeService
import com.im.cookgaloreapp.data.remote.util.RecipesResponseMapper
import com.im.cookgaloreapp.domain.Recipes.Recipes

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepository_Impl
@Inject
constructor(
    private val recipeService: RecipeService,
    private val responseMapper: RecipesResponseMapper,
    private val cacheMapper: RecipesCacheMapper,
    val recipesDao: RecipesDao,
) : RecipeRepository {

    override suspend fun searchRecipes(auth: String, page: Int, query: String): List<Recipes> {
        val response = recipeService.getRecipes(auth, page, query).recipes
        return responseMapper.mapFromEntityList(response)
    }

    override fun getRecipes(): Flow<List<Recipes>> {
        return cacheMapper.mapFromEntityFlowList(recipesDao.getRecipes())
    }

    override fun ifRecipesExists(recipe: Int): Flow<Int> {
        return recipesDao.ifExists(recipe = recipe)
    }

    override suspend fun insertRecipes(recipes: Recipes) {
        recipesDao.insert(cacheMapper.toEntity(recipes))
    }

    override suspend fun deleteRecipes(recipes: Recipes) {
        recipesDao.delete(cacheMapper.toEntity(recipes))
    }


}