package com.im.cookgaloreapp.di

import android.content.Context
import androidx.room.Room
import com.im.cookgaloreapp.data.local.bookmark.BookmarkDao
import com.im.cookgaloreapp.data.local.database.RecipesDB
import com.im.cookgaloreapp.data.local.recipe.RecipesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideRecipesDatabase(@ApplicationContext context: Context): RecipesDB{
        return Room.databaseBuilder(
            context.applicationContext,
            RecipesDB::class.java,
            RecipesDB.TABLE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideRecipesDao(recipesDB: RecipesDB): RecipesDao{
        return recipesDB.getRecipesDao()
    }

    @Singleton
    @Provides
    fun provideBookmarkRecipesDao(recipesDB: RecipesDB): BookmarkDao{
        return recipesDB.getBookmarkDao()
    }

}