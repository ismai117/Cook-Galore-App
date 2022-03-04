package com.im.cookgaloreapp.data.local.favourites

import androidx.room.*
import com.im.cookgaloreapp.data.local.bookmark.BookmarkCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Query("SELECT * FROM favourites_table")
    fun getFavourites(): Flow<List<FavouritesCacheEntity>>

    @Query("SELECT COUNT() FROM favourites_table WHERE id = :favourites")
    fun ifFavouritesExists(favourites: Int): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favourites: FavouritesCacheEntity)

    @Delete
    suspend fun delete(favourites: FavouritesCacheEntity)

    @Query("DELETE FROM favourites_table")
    fun deleteFavouritesRecipes()

}