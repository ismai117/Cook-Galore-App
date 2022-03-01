package com.im.cookgaloreapp.ui.screens.myrecipes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.repository.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.NetworkState
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyRecipesViewModel
@Inject
constructor(
    private val repositoryImpl: RecipeRepository_Impl,
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

                if (it.isNullOrEmpty()) {
                    _myRecipes.value = ViewState.Empty
                } else {
                    _myRecipes.value = ViewState.Success(it)
                }

            }

        }

    }

}