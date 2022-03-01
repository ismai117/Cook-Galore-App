package com.im.cookgaloreapp.ui.screens.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.repository.RecipeRepository_Impl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel
@Inject
constructor(
    private val repositoryImpl: RecipeRepository_Impl
) : ViewModel() {


    fun insertRecipe(recipes: Recipes){
        viewModelScope.launch {
            repositoryImpl.insert(recipes = recipes)
        }
    }

    fun ifExists(recipe: Int): Flow<Int> {
        return repositoryImpl.ifExists(recipe = recipe)
    }


}