package com.im.cookgaloreapp.repository.bookmark

import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {


    fun getBookmarks(): Flow<List<Recipes>>

    fun ifBookmarkExists(bookmark: Int): Flow<Int>

    suspend fun insertBookmark(bookmark: Recipes)

    suspend fun deleteBookmark(bookmark: Recipes)

}