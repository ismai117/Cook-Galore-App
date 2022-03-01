package com.im.cookgaloreapp.di

import com.im.cookgaloreapp.data.local.util.BookmarkCacheMapper
import com.im.cookgaloreapp.data.local.util.RecipesCacheMapper
import com.im.cookgaloreapp.data.remote.util.RecipesResponseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {


    @Singleton
    @Provides
    fun provideRecipesResponseMapper(): RecipesResponseMapper{
        return RecipesResponseMapper()
    }

    @Singleton
    @Provides
    fun provideRecipesCacheMapper(): RecipesCacheMapper{
        return RecipesCacheMapper()
    }

    @Singleton
    @Provides
    fun provideBookmarkCacheMapper(): BookmarkCacheMapper {
        return BookmarkCacheMapper()
    }

}