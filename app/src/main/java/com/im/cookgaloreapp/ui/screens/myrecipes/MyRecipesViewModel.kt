package com.im.cookgaloreapp.ui.screens.myrecipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.repository.favourite.FavouriteRepository
import com.im.cookgaloreapp.repository.favourite.FavouriteRepository_Impl
import com.im.cookgaloreapp.repository.recipe.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MyRecipesViewModel
@Inject
constructor(
    private val repositoryImpl: RecipeRepository_Impl,
    private val favouriteRepository_Impl: FavouriteRepository_Impl
) : ViewModel() {

    private val _myRecipes = MutableStateFlow<ViewState>(ViewState.Success(emptyList()))
    val myRecipes: StateFlow<ViewState> = _myRecipes

    init {
        getAllRecipes()
    }

    private fun getAllRecipes() {

        _myRecipes.value = ViewState.Loading

        viewModelScope.launch {

            repositoryImpl.getRecipes().collect {

                try {

                    if (it.isNullOrEmpty()) {

                        _myRecipes.value = ViewState.Empty

                    } else {

                        _myRecipes.value = ViewState.Success(it)

                    }

                } catch (exception: Exception){

                    _myRecipes.value = ViewState.Error(exception)

                }

            }

        }

    }

    fun insertFavouriteRecipe(recipes: Recipes){
        viewModelScope.launch {
            favouriteRepository_Impl.insertFavourites(recipes)
        }
    }

    fun ifFavouriteRecipeExists(recipe: Int): Flow<Int> {
        return favouriteRepository_Impl.ifFavouritesExists(recipe)
    }


}