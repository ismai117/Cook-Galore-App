package com.im.cookgaloreapp.ui.screens.bookmark

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.ProgressBar
import com.im.cookgaloreapp.ui.screens.myrecipes.MyRecipesList
import com.im.cookgaloreapp.ui.theme.Fonts
import com.im.cookgaloreapp.utils.ViewState


@Composable
fun BookmarkScreen(
    bookmarkViewModel: BookmarkViewModel,
    bookmarkListState: LazyListState,
    context: Context,
) {

    val bookmarks = bookmarkViewModel.bookmark.collectAsState().value

    when (bookmarks) {

        is ViewState.Success -> {

            BookmarkUI(
                bookmarks = bookmarks.recipes,
                bookmarkListState = bookmarkListState,
                context = context
            )

        }

        is ViewState.Loading -> {

            ProgressBar(isEnabled = true)

        }


        is ViewState.Error -> {

        }

        is ViewState.Empty -> {

            Toast.makeText(context, "empty", Toast.LENGTH_LONG).show()

        }

    }

}


@Composable
fun BookmarkUI(bookmarks: List<Recipes>, bookmarkListState: LazyListState, context: Context) {

    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.padding(top = 50.dp, start = 24.dp)
        ) {
            Text(
                text = "Bookmark",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = Fonts
                ),
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }

        BookmarkList(bookmarks = bookmarks,
            bookmarkListState = bookmarkListState,
            context = context)

    }

}