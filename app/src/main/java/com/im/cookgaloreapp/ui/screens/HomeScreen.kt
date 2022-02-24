package com.im.cookgaloreapp.ui.screens

import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.ui.theme.CookGaloreAppTheme
import com.im.cookgaloreapp.ui.theme.Fonts


@Composable
fun HomeScreen(
    navController: NavController,
) {

    val query = remember { mutableStateOf("") }
    val context = LocalContext.current
    val items = listOf("All", "Sushi", "Pizza", "Burger", "Pasta")
    val images = listOf(R.drawable.sushi_image, R.drawable.pizza_image, R.drawable.burger_image, R.drawable.pizza_image)

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(top = 60.dp, start = 24.dp)
        ) {
            Text(
                text = "Discover Best Recipe",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = Fonts
                ),
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "For Cooking",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = Fonts
                ),
            )
            TextField(
                value = query.value,
                onValueChange = { query.value = it },
                label = {
                    Text(text = "Find Recipe")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = "",
                        modifier = Modifier.clickable {

                        },
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, end = 24.dp),
                keyboardActions = KeyboardActions(onSearch = {

                }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.Black,
                    cursorColor = Color.Black
                ),
            )
        }
        LazyRow(
            modifier = Modifier.padding(top = 40.dp, start = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = items
            ) { index, item ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color(0xFF00A300),
                ){
                    Column(
                        modifier = Modifier
                            .height(45.dp)
                            .width(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "$item",
                            style = TextStyle(
                                color = Color.White,
                                 fontSize = 16.sp,
                                fontFamily = Fonts
                            )
                        )
                    }
                }
            }
        }
        LazyColumn(
            modifier = Modifier.padding(top = 60.dp, start = 24.dp, end = 24.dp),
           verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            itemsIndexed(
                items = images,
            ){ index, item ->
                Card(
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    ){
                        Image(
                            painter = painterResource(id = item),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CookGaloreAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}