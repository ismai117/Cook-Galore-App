package com.im.cookgaloreapp.ui.screens.home

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.im.cookgaloreapp.ui.theme.Fonts


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OptionsList(
    navController: NavController,
    optionsListState: LazyListState,
    homeViewModel: HomeViewModel,
    titles: List<RecipeCategory>,
    context: Context,
) {
    LazyRow(
        state = optionsListState,
        contentPadding = PaddingValues(end = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(top = 30.dp, start = 24.dp),
    ) {

        itemsIndexed(
            items = titles
        ) { index, item ->

            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color(0xFF00A300),
                onClick = {
                    homeViewModel.searchRecipes(item.name)
                }
            ) {
                Column(
                    modifier = Modifier
                        .height(45.dp)
                        .width(120.dp)
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${item.name}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = Fonts
                        )
                    )
                }
            }

        }

    }
}