package com.im.cookgaloreapp.ui.screens.bookmark

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.repository.bookmark.BookmarkRepository_Impl
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel
@Inject
constructor(
    private val bookmarkRepository_Impl: BookmarkRepository_Impl
) : ViewModel() {

    private val _bookmark = MutableStateFlow<ViewState>(ViewState.Success(emptyList()))
    val bookmark: StateFlow<ViewState> = _bookmark

    init {
        viewModelScope.launch {
            delay(2000)
            getAllBookmarks()
        }
    }

    private fun getAllBookmarks() {

        viewModelScope.launch(Dispatchers.IO) {

            _bookmark.value = ViewState.Loading

            try {

                bookmarkRepository_Impl.getBookmarks().collect {

                    if (it.isNullOrEmpty()) {

                        _bookmark.value = ViewState.Empty

                        Log.d("recipesBookmark", "empty")

                    } else {

                        Log.d("recipesBookmark", "$it")
                        _bookmark.value = ViewState.Success(it)

                    }
                }

            } catch (exception: Exception) {

                _bookmark.value = ViewState.Error(exception)

            }


        }

    }

}