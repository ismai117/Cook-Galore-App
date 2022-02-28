package com.im.cookgaloreapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ProgressBar(
    isEnabled: Boolean
){

   Box(
       modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.Center
   ){
       if (isEnabled){
           CircularProgressIndicator(color = Color(0xFF00A300))
       }else{

       }
   }

}