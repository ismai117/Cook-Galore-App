package com.im.cookgaloreapp.ui.screens.bookmark

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.imageLoader


@Composable
fun BookmarkCard(bookmark: Recipes, context: Context) {

    Card(
        elevation = 12.dp,
        shape = RoundedCornerShape(12.dp),
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(15.dp)
        ) {
            Text(
                text = "${bookmark.title}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp
                )
            )
            Spacer(modifier = Modifier.padding(12.dp))
            val image = bookmark.featured_image?.let { imageLoader(url = it, resource = R.drawable.placeholder, context = context).value }
            image?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                )
            }
        }

    }

}
