package com.im.cookgaloreapp.ui.components

import android.content.Context
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.ui.screens.HomeScreen
import com.im.cookgaloreapp.ui.screens.bookmark.BookmarkScreen
import com.im.cookgaloreapp.ui.screens.bookmark.FavouriteScreen
import com.im.cookgaloreapp.ui.screens.home.HomeViewModel
import com.im.cookgaloreapp.ui.screens.myrecipes.MyRecipesScreen
import com.im.cookgaloreapp.ui.screens.recipe.RecipeDetailScreen
import com.im.cookgaloreapp.utils.AssetParamType
import com.im.cookgaloreapp.utils.Screen

import kotlinx.coroutines.CoroutineScope


@Composable
fun NavigationGraph(
    navController: NavController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    homeViewModel: HomeViewModel,
    optionsListState: LazyListState,
    recipesListState: LazyListState,
    context: Context,
    bottomNavState: MutableState<Boolean>,
) {

    NavHost(
        navController = navController as NavHostController,
       startDestination = Screen.HomeScreen.route
    ){

        composable(route = Screen.HomeScreen.route){
            LaunchedEffect(Unit){
                bottomNavState.value = true
            }
            HomeScreen(
                navController = navController,
                scaffoldState = scaffoldState,
                scope = scope,
                homeViewModel = homeViewModel,
                optionsListState = optionsListState,
                recipesListState = recipesListState,
            )
        }

        composable(route = Screen.BookmarkScreen.route){
            LaunchedEffect(Unit){
                bottomNavState.value = true
            }
            BookmarkScreen()
        }

        composable(route = Screen.MyRecipesScreen.route){
            LaunchedEffect(Unit){
                bottomNavState.value = true
            }
            MyRecipesScreen()
        }

        composable(route = Screen.FavouriteScreen.route){
            LaunchedEffect(Unit){
                bottomNavState.value = true
            }
            FavouriteScreen()
        }

        composable(
            route = Screen.RecipeDetailScreen.route + "{recipes}",
            arguments = listOf(navArgument("recipes"){
                type = AssetParamType()
            })
        ){ navBackStackEntry ->
            LaunchedEffect(Unit){
                bottomNavState.value = false
            }
            val recipes = navBackStackEntry.arguments?.getParcelable<Recipes>("recipes")
           recipes?.let {
               RecipeDetailScreen(it, context = context)
           }
        }

    }

}