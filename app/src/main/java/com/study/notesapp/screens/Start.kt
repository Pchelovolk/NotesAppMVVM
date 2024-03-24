package com.study.notesapp.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.study.notesapp.MainViewModel
import com.study.notesapp.MainViewModelFactory
import com.study.notesapp.navigation.NavRoute
import com.study.notesapp.ui.theme.NotesAppTheme
import com.study.notesapp.utils.TYPE_FIREBASE
import com.study.notesapp.utils.TYPE_ROOM

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController) {
    // Будут нах-ся текстовое поле и 2 кнопки (локальная и удалённая базы данных)

    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    
    Scaffold (
        modifier = Modifier.fillMaxSize()

    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "What wiil we USE?")
            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_ROOM)
                    navController.navigate(route = NavRoute.Main.route) },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Room database")
            }

            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_FIREBASE)
                    navController.navigate(route = NavRoute.Main.route) },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "FireBase database")
            }

        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun  prevStartScreen(){
    NotesAppTheme {
        StartScreen(navController = rememberNavController())
    }
}