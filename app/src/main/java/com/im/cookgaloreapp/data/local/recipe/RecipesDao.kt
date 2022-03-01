package com.im.cookgaloreapp.data.local.recipe

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Query("SELECT * FROM recipes_table")
    fun getRecipes(): Flow<List<RecipesCacheEntity>>

    @Query("SELECT COUNT() FROM recipes_table WHERE id = :recipe")
    fun ifExists(recipe: Int): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipes: RecipesCacheEntity)

    @Delete
    suspend fun delete(recipes: RecipesCacheEntity)

    @Query("DELETE FROM recipes_table")
    fun deleteRecipes()

}