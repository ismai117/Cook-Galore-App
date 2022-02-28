package com.im.cookgaloreapp.di

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

}