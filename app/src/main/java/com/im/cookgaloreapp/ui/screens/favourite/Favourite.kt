package com.im.cookgaloreapp.ui.screens.bookmark

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.im.cookgaloreapp.ui.screens.favourite.FavouriteList
import com.im.cookgaloreapp.ui.screens.favourite.FavouriteViewModel
import com.im.cookgaloreapp.ui.theme.Fonts
import com.im.cookgaloreapp.utils.ViewState


@Composable
fun FavouriteScreen(favouriteViewModel: FavouriteViewModel, favouritesListState: LazyListState, context: Context) {

    val favourites = favouriteViewModel.favourites.collectAsState().value


    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.padding(top = 50.dp, start = 24.dp)
        ) {
            Text(
                text = "Favourites",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = Fonts
                ),
            )
            Spacer(modifier = Modifier.padding(12.dp))
        }


        when (favourites) {

            is ViewState.Success -> {

                FavouriteList(
                    favourites.recipes,
                    favouritesListState,
                    context
                )

            }

            is ViewState.Loading -> {

                ProgressBar(isEnabled = true)

            }

            is ViewState.Error -> {

            }

            is ViewState.Empty -> {



            }

        }
    }

}
