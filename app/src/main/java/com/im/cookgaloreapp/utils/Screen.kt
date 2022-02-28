package com.im.cookgaloreapp.utils

import com.im.cookgaloreapp.R

sealed class Screen(val title: String, val icon: Int, val route: String){

    object StartingScreen : Screen("", 0,"starting_screen")
    object HomeScreen : Screen("", R.drawable.ic_home, "home_screen")
    object BookmarkScreen : Screen("", R.drawable.ic_bookmark, "bookmark_screen")
    object MyRecipesScreen : Screen("", R.drawable.ic_bag, "myrecipes_screen")
    object FavouriteScreen : Screen("", R.drawable.ic_favorite, "favourite_screen")
    object RecipeDetailScreen : Screen("", 0,"recipedetail_screen")

}
