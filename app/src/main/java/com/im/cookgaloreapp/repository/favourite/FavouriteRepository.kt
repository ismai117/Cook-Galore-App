package com.im.cookgaloreapp.repository.favourite

import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {


    fun getFavourites(): Flow<List<Recipes>>

    fun ifFavouritesExists(favourites: Int): Flow<Int>

    suspend fun insertFavourites(favourites: Recipes)

    suspend fun deleteFavourites(favourites: Recipes)

}