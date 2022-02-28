package com.im.cookgaloreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.im.cookgaloreapp.ui.components.BottomNav
import com.im.cookgaloreapp.ui.components.NavigationGraph
import com.im.cookgaloreapp.ui.screens.home.HomeViewModel
import com.im.cookgaloreapp.ui.theme.CookGaloreAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CookGaloreAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MainScreen(homeViewModel)
                }
            }

        }
    }

    @Composable
    fun MainScreen(homeViewModel: HomeViewModel) {

        val scaffoldState = rememberScaffoldState()
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val optionsListState = rememberLazyListState()
        val recipesListState = rememberLazyListState()

        val bottomNavState = rememberSaveable() { mutableStateOf(false) }

        com.google.accompanist.insets.ui.Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomNav(
                    navController = navController,
                    bottomNavState = bottomNavState
                )
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(paddingValues = innerPadding)) {
                NavigationGraph(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    scope = scope,
                    homeViewModel = homeViewModel,
                    optionsListState = optionsListState,
                    recipesListState = recipesListState,
                    context = this@MainActivity,
                    bottomNavState = bottomNavState
                )
            }
        }

    }



}