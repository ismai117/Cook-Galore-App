package com.im.cookgaloreapp.ui.screens.myrecipes

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.imageLoader
import com.im.cookgaloreapp.ui.theme.Fonts


@Composable
fun MyRecipesCard(
    recipe: Recipes,
    context: Context,
    favoured: () -> Unit
) {

    Card(
        elevation = 12.dp,
        shape = RoundedCornerShape(12.dp),
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
        ) {
            val image = recipe.featured_image?.let {
                imageLoader(url = it,
                    resource = R.drawable.placeholder,
                    context = context).value
            }
            image?.let {
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
            Text(
                text = "${recipe.title}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = Fonts
                ),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(24.dp)
            )
            Image(
                imageVector = Icons.Filled.Favorite,
                colorFilter = ColorFilter.tint(color = Color.White),
                contentDescription = "",
                modifier = Modifier
                    .padding(20.dp)
                    .size(24.dp)
                    .align(Alignment.BottomEnd)
                    .clickable {
                        favoured()
                    }
            )
        }

    }

}
