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

sealed class NavRoute(val route: String){

    // инициализация экранов
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
    // далее, создаём NavController
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Start.route){

        // теперь создадим сами экраны...

        composable(NavRoute.Start.route){ StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route){ MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route){ AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route){ NoteScreen(navController = navController, viewModel = mViewModel) }
        //далее, в Main activivty подключим эту composable функцию...
    }
}