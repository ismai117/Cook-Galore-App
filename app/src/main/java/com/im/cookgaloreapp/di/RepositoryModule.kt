package com.im.cookgaloreapp.di

import com.im.cookgaloreapp.data.local.bookmark.BookmarkDao
import com.im.cookgaloreapp.data.local.recipe.RecipesDao
import com.im.cookgaloreapp.data.local.util.BookmarkCacheMapper
import com.im.cookgaloreapp.data.local.util.RecipesCacheMapper
import com.im.cookgaloreapp.data.remote.service.RecipeService
import com.im.cookgaloreapp.data.remote.util.RecipesResponseMapper
import com.im.cookgaloreapp.repository.RecipeRepository
import com.im.cookgaloreapp.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipesResponseMapper: RecipesResponseMapper,
        recipesCacheMapper: RecipesCacheMapper,
        bookmarkCacheMapper: BookmarkCacheMapper,
        recipesDao: RecipesDao,
        bookmarkDao: BookmarkDao
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService,
            recipesResponseMapper,
            recipesCacheMapper,
            bookmarkCacheMapper,
            recipesDao,
            bookmarkDao
        )
    }

}