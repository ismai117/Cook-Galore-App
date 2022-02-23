package com.im.cookgaloreapp.utils

sealed class Screen(val route: String){

    object StartingScreen : Screen("starting_screen")
    object HomeScreen : Screen("home_screen")

}
