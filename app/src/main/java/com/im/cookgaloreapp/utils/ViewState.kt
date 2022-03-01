package com.im.cookgaloreapp.utils

import com.im.cookgaloreapp.domain.Recipes.Recipes

sealed class ViewState {

    class Success(val recipes: List<Recipes>) : ViewState()
    class Error(val throwable: Throwable) : ViewState()
    object Loading : ViewState()
    object Empty : ViewState()

}
