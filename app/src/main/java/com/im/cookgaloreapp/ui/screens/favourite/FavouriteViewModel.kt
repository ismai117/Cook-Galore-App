package com.im.cookgaloreapp.ui.screens.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.repository.favourite.FavouriteRepository_Impl
import com.im.cookgaloreapp.repository.recipe.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel
@Inject
constructor(
    private val favouriteRepositoryImpl: FavouriteRepository_Impl
) : ViewModel() {

    private val _favourites = MutableStateFlow<ViewState>(ViewState.Success(emptyList()))
    val favourites: StateFlow<ViewState> = _favourites


    init {
        getFavourites()
    }

    private fun getFavourites() {

        _favourites.value = ViewState.Loading

        viewModelScope.launch {

            favouriteRepositoryImpl.getFavourites().collect {

                try {

                    if (it.isNullOrEmpty()) {

                        _favourites.value = ViewState.Empty

                    } else {

                        _favourites.value = ViewState.Success(it)

                    }

                } catch (exception: Exception){

                    _favourites.value = ViewState.Error(exception)

                }

            }

        }

    }


}