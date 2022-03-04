package com.im.cookgaloreapp.repository.favourite

import com.im.cookgaloreapp.data.local.favourites.FavouritesDao
import com.im.cookgaloreapp.data.local.util.FavouritesCacheMapper
import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouriteRepository_Impl
@Inject
constructor(
    private val favouritesCacheMapper: FavouritesCacheMapper,
    val favouritesDao: FavouritesDao
) : FavouriteRepository {


    override fun getFavourites(): Flow<List<Recipes>> {
        return favouritesCacheMapper.mapFromEntityFlowList(favouritesDao.getFavourites())
    }

    override fun ifFavouritesExists(favourites: Int): Flow<Int> {
        return favouritesDao.ifFavouritesExists(favourites)
    }

    override suspend fun insertFavourites(favourites: Recipes) {
        favouritesDao.insert(favouritesCacheMapper.toEntity(favourites))
    }

    override suspend fun deleteFavourites(favourites: Recipes) {
        favouritesDao.delete(favouritesCacheMapper.toEntity(favourites))

    }

}