package com.im.cookgaloreapp.ui.screens.favourite

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.screens.bookmark.BookmarkCard


@Composable
fun FavouriteList(
    favourites: List<Recipes>,
    favouriteListState: LazyListState,
    context: Context
) {

    LazyColumn(
        state = favouriteListState,
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        itemsIndexed(
            items = favourites
        ) { index, favourite ->

            FavouriteCard(favourites = favourite, context = context)
            Log.d("myRecipes", "${favourite.title}")

        }

    }

}
