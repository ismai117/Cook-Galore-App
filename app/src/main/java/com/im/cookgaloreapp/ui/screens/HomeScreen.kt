package com.im.cookgaloreapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.im.cookgaloreapp.ui.theme.CookGaloreAppTheme


@Composable
fun HomeScreen(
    navController: NavController)
{
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            Text(
                text = "Discover the best recipes",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                ),
            )
            Text(
                text = "for cooking",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CookGaloreAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}