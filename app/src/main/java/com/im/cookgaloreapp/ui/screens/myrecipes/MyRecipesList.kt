package com.im.cookgaloreapp.ui.screens.myrecipes

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.cookgaloreapp.R
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.components.imageLoader
import com.im.cookgaloreapp.ui.screens.bookmark.BookmarkViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@Composable
fun MyRecipesList(
    myRecipesViewModel: MyRecipesViewModel,
    scope: CoroutineScope,
    recipes: List<Recipes>,
    myRecipesListState: LazyListState,
    context: Context,
) {

    LazyColumn(
        state = myRecipesListState,
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        itemsIndexed(
            items = recipes
        ) { index, recipe ->

            MyRecipesCard(
                recipe = recipe,
                context = context,
                favoured = {
                    recipe.id?.let {
                        scope.launch {
                            myRecipesViewModel.ifFavouriteRecipeExists(it).collect { itemExist ->
                                if (itemExist <= 0){
                                    myRecipesViewModel.insertFavouriteRecipe(recipe)
                                }else{
                                    Toast.makeText(context, "favoured already", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                }
            )
            Log.d("myRecipes", "${recipe.title}")

        }

    }

}



