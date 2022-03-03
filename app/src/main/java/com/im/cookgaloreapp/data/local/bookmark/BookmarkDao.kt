package com.im.cookgaloreapp.data.local.bookmark

import androidx.room.*
import com.im.cookgaloreapp.data.local.recipe.RecipesCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM bookmark_table")
    fun getBookmarks(): Flow<List<BookmarkCacheEntity>>

    @Query("SELECT COUNT() FROM bookmark_table WHERE id = :bookmark")
    fun ifBookmarkExists(bookmark: Int): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmark: BookmarkCacheEntity)

    @Delete
    suspend fun delete(bookmark: BookmarkCacheEntity)

    @Query("DELETE FROM bookmark_table")
    fun deleteBookmarkRecipes()

}