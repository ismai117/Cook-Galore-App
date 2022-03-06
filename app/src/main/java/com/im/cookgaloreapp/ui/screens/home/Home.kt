package com.im.cookgaloreapp.ui.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.ui.components.ProgressBar
import com.im.cookgaloreapp.ui.screens.home.HomeViewModel
import com.im.cookgaloreapp.ui.screens.home.OptionsList
import com.im.cookgaloreapp.ui.screens.home.RecipesList
import com.im.cookgaloreapp.ui.theme.Fonts
import com.im.cookgaloreapp.utils.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    homeViewModel: HomeViewModel,
    optionsListState: LazyListState,
    recipesListState: LazyListState,
) {

    val recipes = homeViewModel.recipes.collectAsState().value
    val query = homeViewModel.query.value
    val categories = homeViewModel.categories.value
    val context = LocalContext.current
    val softKeyboardController = LocalSoftwareKeyboardController.current
    val bookmarked = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .padding(top = 50.dp, start = 24.dp)
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
                value = query,
                onValueChange = { homeViewModel.onChangedQuery(it) },
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
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, end = 24.dp),
                keyboardActions = KeyboardActions(onSearch = {
                    if (query != "") {
                        homeViewModel.searchRecipes(query)
                    } else {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Empty query")
                        }
                    }
                    softKeyboardController?.hide()
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

        OptionsList(
            navController = navController,
            optionsListState = optionsListState,
            homeViewModel = homeViewModel,
            context = context,
            titles = categories)

        when (recipes) {

            is ViewState.Success -> {


                RecipesList(
                    navController = navController,
                    scope = scope,
                    homeViewModel = homeViewModel,
                    recipes = recipes.recipes,
                    recipesListState = recipesListState,
                    context = context
                )


            }

            is ViewState.Error -> {

                LaunchedEffect(scope) {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("${recipes.throwable.message}")
                    }
                }

            }

            is ViewState.Loading -> {

                ProgressBar(isEnabled = true)

            }


            is ViewState.Empty -> {

                Log.d("recipesSearch", "Empty")

            }

        }
    }

}

