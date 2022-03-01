package com.im.cookgaloreapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.im.cookgaloreapp.data.local.bookmark.BookmarkCacheEntity
import com.im.cookgaloreapp.data.local.bookmark.BookmarkDao
import com.im.cookgaloreapp.data.local.converters.Converter
import com.im.cookgaloreapp.data.local.recipe.RecipesCacheEntity
import com.im.cookgaloreapp.data.local.recipe.RecipesDao

@Database(
    entities = [RecipesCacheEntity::class,BookmarkCacheEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class RecipesDB : RoomDatabase() {

    abstract fun getRecipesDao(): RecipesDao
    abstract fun getBookmarkDao(): BookmarkDao

    companion object {

        val TABLE_NAME = "recipes_table"

    }

}