package com.im.cookgaloreapp.ui.screens.bookmark

import androidx.lifecycle.ViewModel
import com.im.cookgaloreapp.domain.bookmark.Bookmark
import com.im.cookgaloreapp.repository.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.NetworkState
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
        getAllBookmark()
    }

    fun getAllBookmark(){

        _bookmark.value = ViewState.Loading




    }

}