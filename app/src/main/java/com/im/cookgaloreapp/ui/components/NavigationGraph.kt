package com.im.cookgaloreapp.ui.components

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.im.cookgaloreapp.ui.screens.HomeScreen
import com.im.cookgaloreapp.utils.Screen
import kotlinx.coroutines.CoroutineScope


@Composable
fun NavigationGraph(
    navController: NavController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {

    NavHost(
        navController = navController as NavHostController,
       startDestination = Screen.HomeScreen.route
    ){

        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }

    }

}