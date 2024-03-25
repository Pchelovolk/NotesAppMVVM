package com.study.notesapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.study.notesapp.MainViewModel
import com.study.notesapp.model.Note
import com.study.notesapp.navigation.NavRoute
import com.study.notesapp.utils.Constants
import com.study.notesapp.utils.DB_TYPE
import com.study.notesapp.utils.TYPE_FIREBASE
import com.study.notesapp.utils.TYPE_ROOM

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {

    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NavRoute.Add.route) }
            ) {
             Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Icons", tint = Color.White)
            }
        }
    ){
//        Column (){
//            NoteItem(title = "Note 1", subtitle = "Subtitle for note 1", navController = navController)
//            NoteItem(title = "Note 2", subtitle = "Subtitle for note 2", navController = navController)
//            NoteItem(title = "Note 3", subtitle = "Subtitle for note 3", navController = navController)
//            NoteItem(title = "Note 4", subtitle = "Subtitle for note 4", navController = navController)
//        }

        LazyColumn {
            items(notes) { note ->
                NoteItem(note = note, navController = navController)
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, navController: NavHostController){
    val noteId = when(DB_TYPE){
        TYPE_FIREBASE -> note.firebaseId
        TYPE_ROOM -> note.id
        else -> Constants.Keys.EMPTY
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable { navController.navigate(NavRoute.Note.route + "/${noteId}")
            },
        elevation = 6.dp
    ){
        Column (modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = note.subtitle)
        }

    }
}
