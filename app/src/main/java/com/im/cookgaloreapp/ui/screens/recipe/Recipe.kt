package com.im.cookgaloreapp.ui.screens.recipe

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.imageLoader
import com.im.cookgaloreapp.ui.theme.Fonts


@Composable
fun RecipeDetailScreen(
    recipes: Recipes,
    context: Context,
) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ) {

        Column(modifier = Modifier.fillMaxWidth()){
            Card(
                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
            ) {
                val image = recipes.featured_image?.let {
                    imageLoader(
                        url = it,
                        resource = R.drawable.placeholder,
                        context = context).value
                }
                image?.asImageBitmap()?.let {
                    Image(
                        bitmap = it,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(340.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "${recipes.title}",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = Fonts,
                    fontSize = 22.sp
                ),
                modifier = Modifier.padding(top = 40.dp, start = 24.dp, end = 34.dp)
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            recipes.ingredients?.forEach {
                Text(
                    text = it,
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = Fonts,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.padding(start = 24.dp, top = 8.dp, end = 50.dp)
                )
            }

        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00A300), contentColor = Color.White),
            modifier = Modifier.align(Alignment.CenterHorizontally).height(50.dp).width(150.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = "Add Reciepe")
        }

        Spacer(modifier = Modifier.padding(20.dp))

    }

}
