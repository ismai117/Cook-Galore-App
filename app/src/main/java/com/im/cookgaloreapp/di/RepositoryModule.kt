package com.im.cookgaloreapp.di

import com.im.cookgaloreapp.data.local.bookmark.BookmarkDao
import com.im.cookgaloreapp.data.local.favourites.FavouritesDao
import com.im.cookgaloreapp.data.local.recipe.RecipesDao
import com.im.cookgaloreapp.data.local.util.BookmarkCacheMapper
import com.im.cookgaloreapp.data.local.util.FavouritesCacheMapper
import com.im.cookgaloreapp.data.local.util.RecipesCacheMapper
import com.im.cookgaloreapp.data.remote.service.RecipeService
import com.im.cookgaloreapp.data.remote.util.RecipesResponseMapper
import com.im.cookgaloreapp.repository.bookmark.BookmarkRepository
import com.im.cookgaloreapp.repository.bookmark.BookmarkRepository_Impl
import com.im.cookgaloreapp.repository.favourite.FavouriteRepository
import com.im.cookgaloreapp.repository.favourite.FavouriteRepository_Impl
import com.im.cookgaloreapp.repository.recipe.RecipeRepository
import com.im.cookgaloreapp.repository.recipe.RecipeRepository_Impl
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
        recipesDao: RecipesDao,
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService,
            recipesResponseMapper,
            recipesCacheMapper,
            recipesDao,
        )
    }

    @Singleton
    @Provides
    fun provideBookmarkRepository(
        bookmarkCacheMapper: BookmarkCacheMapper,
        bookmarkDao: BookmarkDao,
    ): BookmarkRepository {
        return BookmarkRepository_Impl(
            bookmarkCacheMapper,
            bookmarkDao,
        )
    }

    @Singleton
    @Provides
    fun provideFavouriteRepository(
        favouritesCacheMapper: FavouritesCacheMapper,
        favouritesDao: FavouritesDao,
    ): FavouriteRepository {
        return FavouriteRepository_Impl(
            favouritesCacheMapper,
            favouritesDao
        )
    }

}