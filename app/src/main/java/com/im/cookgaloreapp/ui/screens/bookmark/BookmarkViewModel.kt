package com.im.cookgaloreapp.ui.screens.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.repository.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.NetworkState
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel
@Inject
constructor(
    private val repositoryImpl: RecipeRepository_Impl,
) : ViewModel() {

    private val _bookmark = MutableStateFlow<ViewState>(ViewState.Success(emptyList()))
    val bookmark: StateFlow<ViewState> = _bookmark

    init {
        getAllBookmarks()
    }

    private fun getAllBookmarks(){

        _bookmark.value = ViewState.Loading

        viewModelScope.launch {

            repositoryImpl.getBookmarks().collect {

                if (it.isNullOrEmpty()){
                    _bookmark.value = ViewState.Empty
                }else{
                    _bookmark.value = ViewState.Success(it)
                }

            }

        }

    }

}