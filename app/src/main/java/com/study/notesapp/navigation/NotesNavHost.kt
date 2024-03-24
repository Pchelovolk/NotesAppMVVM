package com.study.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.notesapp.MainViewModel
import com.study.notesapp.screens.AddScreen
import com.study.notesapp.screens.MainScreen
import com.study.notesapp.screens.NoteScreen
import com.study.notesapp.screens.StartScreen
import com.study.notesapp.utils.Constants

sealed class NavRoute(val route: String){

    data object Start: NavRoute(Constants.Screens.START_SCREEN)
    data object Main: NavRoute(Constants.Screens.MAIN_SCREEN)
    data object Add: NavRoute(Constants.Screens.ADD_SCREEN)
    data object Note: NavRoute(Constants.Screens.NOTE_SCREEN)

}

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Start.route){

        composable(NavRoute.Start.route){ StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route){ MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route){ AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}"){ backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteID = backStackEntry.arguments?.getString(Constants.Keys.ID)) }

    }
}