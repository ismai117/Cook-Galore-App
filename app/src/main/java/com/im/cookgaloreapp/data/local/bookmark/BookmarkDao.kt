package com.im.cookgaloreapp.data.local.bookmark

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.im.cookgaloreapp.data.local.recipe.RecipesCacheEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkDao {

    @Query("SELECT * FROM bookmark_table")
    fun getBookmarkRecipes(): Flow<List<BookmarkCacheEntity>>

    @Query("SELECT COUNT() FROM recipes_table WHERE id = :recipe")
    fun ifExists(recipe: Int): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipes: BookmarkCacheEntity)

    @Delete
    suspend fun delete(recipes: BookmarkCacheEntity)

    @Query("DELETE FROM bookmark_table")
    fun deleteBookmarkRecipes()

}