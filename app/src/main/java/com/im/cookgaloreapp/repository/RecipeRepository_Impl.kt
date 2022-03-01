package com.im.cookgaloreapp.repository

import com.im.cookgaloreapp.data.local.bookmark.BookmarkDao
import com.im.cookgaloreapp.data.local.recipe.RecipesDao
import com.im.cookgaloreapp.data.local.util.BookmarkCacheMapper
import com.im.cookgaloreapp.data.local.util.RecipesCacheMapper
import com.im.cookgaloreapp.data.remote.service.RecipeService
import com.im.cookgaloreapp.data.remote.util.RecipesResponseMapper
import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepository_Impl
@Inject
constructor(
    val recipeService: RecipeService,
    val responseMapper: RecipesResponseMapper,
    val cacheMapper: RecipesCacheMapper,
    val bookmarkCacheMapper: BookmarkCacheMapper,
    val recipesDao: RecipesDao,
    val bookmarkDao: BookmarkDao
) : RecipeRepository{

    override suspend fun searchRecipes(auth: String, page: Int, query: String): List<Recipes> {
        val response = recipeService.getRecipes(auth, page, query).recipes
        return responseMapper.mapFromEntityList(response)
    }

    override fun getRecipes(): Flow<List<Recipes>> {
        return cacheMapper.mapFromEntityFlowList(recipesDao.getRecipes())
    }

    override fun ifExists(recipe: Int): Flow<Int> {
        return recipesDao.ifExists(recipe = recipe)
    }

    override suspend fun insert(recipes: Recipes) {
        recipesDao.insert(cacheMapper.toEntity(recipes))
    }

    override suspend fun delete(recipes: Recipes) {
        recipesDao.delete(cacheMapper.toEntity(recipes))
    }

}