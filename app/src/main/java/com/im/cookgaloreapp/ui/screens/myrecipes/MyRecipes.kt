package com.im.cookgaloreapp.ui.screens.myrecipes

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.ProgressBar
import com.im.cookgaloreapp.ui.theme.Fonts
import com.im.cookgaloreapp.utils.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@Composable
fun MyRecipesScreen(
    scope: CoroutineScope,
    myRecipesViewModel: MyRecipesViewModel,
    myRecipesListState: LazyListState,
    context: Context
) {


    val recipes = myRecipesViewModel.myRecipes.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.padding(top = 50.dp, start = 24.dp)
        ) {
            Text(
                text = "My Recipes",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = Fonts
                ),
            )
            Spacer(modifier = Modifier.padding(12.dp))
        }

        when (recipes) {

            is ViewState.Success -> {

                MyRecipesList(
                    scope = scope,
                    myRecipesViewModel = myRecipesViewModel,
                    recipes = recipes.recipes,
                    context = context,
                    myRecipesListState = myRecipesListState,
                )

            }

            is ViewState.Loading -> {

                ProgressBar(isEnabled = true)

            }

            is ViewState.Error-> {


            }

            is ViewState.Empty-> {



            }


        }

    }


}

