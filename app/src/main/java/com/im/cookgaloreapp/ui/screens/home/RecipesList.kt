package com.im.cookgaloreapp.ui.screens.home

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.imageLoader
import com.im.cookgaloreapp.ui.theme.Fonts
import com.im.cookgaloreapp.utils.Screen



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipesList(
    navController: NavController,
    recipes: List<Recipes>,
    recipesListState: LazyListState,
    context: Context,
){


    LazyRow(
        state = recipesListState,
        contentPadding = PaddingValues(end = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(top = 30.dp, start = 24.dp),
    ) {

        itemsIndexed(
            items = recipes,
        ) { index, item ->

            Card(
                shape = RoundedCornerShape(40.dp),
                onClick = {
                    val json = Uri.encode(Gson().toJson(item))
                    navController.navigate(Screen.RecipeDetailScreen.route + "$json")
                }
            ) {
                Box(
                    modifier = Modifier
                        .width(270.dp)
                        .height(340.dp)
                ) {
                    val images = item.featured_image?.let {
                        imageLoader(
                            url = it,
                            resource = R.drawable.placeholder,
                            context = context
                        ).value
                    }
                    images?.let {
                        Image(
                            bitmap = it.asImageBitmap(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black),
                            alpha = 0.5f,
                        )
                    }

                    Image(
                        painterResource(
                            id =  R.drawable.ic_bookmark_transparent
                        ),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .height(60.dp)
                            .width(60.dp)
                            .padding(
                                top = 24.dp,
                                end = 24.dp
                            )
                            .clickable {

                            }
                    )


                    Text(
                        text = "${item.title}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp ,
                            fontFamily = Fonts
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .height(95.dp)
                            .padding(
                                start = 24.dp,
                                bottom = 24.dp
                            )
                            .align(Alignment.BottomStart)
                    )
                }
            }

        }
    }


}