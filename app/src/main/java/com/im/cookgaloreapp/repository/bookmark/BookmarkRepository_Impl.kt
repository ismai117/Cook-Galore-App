package com.im.cookgaloreapp.repository.bookmark

import com.im.cookgaloreapp.data.local.bookmark.BookmarkDao
import com.im.cookgaloreapp.data.local.util.BookmarkCacheMapper
import com.im.cookgaloreapp.domain.Recipes.Recipes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkRepository_Impl
@Inject
constructor(
    private val bookmarkCacheMapper: BookmarkCacheMapper,
    val bookmarkDao: BookmarkDao,
) : BookmarkRepository {

    override fun getBookmarks(): Flow<List<Recipes>> {
        return bookmarkCacheMapper.mapFromEntityFlowList(bookmarkDao.getBookmarks())
    }

    override fun ifBookmarkExists(bookmark: Int): Flow<Int> {
        return bookmarkDao.ifBookmarkExists(bookmark = bookmark)
    }

    override suspend fun insertBookmark(bookmark: Recipes) {
        bookmarkDao.insert(bookmarkCacheMapper.toEntity(bookmark))
    }

    override suspend fun deleteBookmark(bookmark: Recipes) {
        bookmarkDao.delete(bookmarkCacheMapper.toEntity(bookmark))
    }

}