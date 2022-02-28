package com.im.cookgaloreapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.im.cookgaloreapp.utils.Screen


@Composable
fun BottomNav(
    navController: NavController,
    bottomNavState: MutableState<Boolean>,
) {

    val navItems = listOf(
        Screen.HomeScreen,
        Screen.BookmarkScreen,
        Screen.MyRecipesScreen,
        Screen.FavouriteScreen
    )

    AnimatedVisibility(
        visible = bottomNavState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 12.dp
            ) {

                val bottomNavBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = bottomNavBackStackEntry?.destination?.route

                navItems.forEach { item ->

                    BottomNavigationItem(
                        icon = {
                            Icon(painter = painterResource(id = item.icon), contentDescription = "")
                        },
                        label = {
                            Text(text = item.title)
                        },
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.LightGray,
                        alwaysShowLabel = true
                    )

                }

            }
        }
    )

}
