package com.im.cookgaloreapp.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.repository.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject
constructor(
    val repositoryImpl: RecipeRepository_Impl
) : ViewModel() {

    private val Authorization = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"

    private val _recipes: MutableState<NetworkState<List<Recipes>>?> = mutableStateOf(null)
    val recipes: MutableState<NetworkState<List<Recipes>>?> = _recipes

    val query = mutableStateOf("")

    init {
        viewModelScope.launch {
            delay(2000)
        }
    }

    fun searchRecipes(query: String){

        viewModelScope.launch(Dispatchers.IO) {

            _recipes.value = NetworkState.Loading()

            try {

                val response = repositoryImpl
                    .searchRecipes(
                        auth = Authorization,
                        page = 1,
                        query = query
                    )

                _recipes.value = NetworkState.Success(response)

            } catch (exception: Exception){

                _recipes.value = NetworkState.Error(exception)

            }


        }

    }

    fun onChangedQuery(query: String){
        this.query.value = query
    }


}