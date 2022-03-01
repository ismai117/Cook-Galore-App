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
import com.im.cookgaloreapp.ui.theme.Fonts
import com.im.cookgaloreapp.utils.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@Composable
fun MyRecipesScreen(myRecipesViewModel: MyRecipesViewModel, myRecipesListState: LazyListState, context: Context) {


    val recipes = myRecipesViewModel.myRecipes.collectAsState().value

    when (recipes) {

        is ViewState.Success -> {

            MyRecipesUI(
                recipes = recipes.recipes,
                context = context,
                myRecipesListState = myRecipesListState,
            )

        }

        is ViewState.Loading -> {


        }

        is ViewState.Error-> {


        }

        is ViewState.Empty-> {

            Toast.makeText(context, "empty", Toast.LENGTH_LONG).show()

        }

    }


}


@Composable
fun MyRecipesUI(recipes: List<Recipes>, context: Context, myRecipesListState: LazyListState) {

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "My Recipes",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontFamily = Fonts
                ),
                modifier = Modifier.padding(top = 40.dp, start = 20.dp)
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        MyRecipesList(recipes = recipes, context = context, myRecipesListState = myRecipesListState,)

    }

}

