package com.im.cookgaloreapp.di

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
        recipesResponseMapper: RecipesResponseMapper
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService,
            recipesResponseMapper
        )
    }

}