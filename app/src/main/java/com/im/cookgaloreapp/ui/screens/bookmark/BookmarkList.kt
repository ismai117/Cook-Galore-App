package com.im.cookgaloreapp.ui.screens.bookmark

import android.content.Context
import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi


import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset

import androidx.compose.ui.unit.dp
import com.im.cookgaloreapp.domain.Recipes.Recipes


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookmarkList(
    bookmarks: List<Recipes>,
    bookmarkListState: LazyListState,
    context: Context,
) {

    LazyColumn(
        state = bookmarkListState,
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        itemsIndexed(
            items = bookmarks,
        ) { index, bookmark ->

            BookmarkCard(bookmark = bookmark, context = context)

            Log.d("myRecipes", "${bookmark.title}")
        }

    }

}
