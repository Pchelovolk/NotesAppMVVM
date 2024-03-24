package com.study.notesapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {

    var title by remember{ mutableStateOf("") }
    var subtitle by remember{ mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }

    Scaffold {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = Constants.Keys.ADD_NEW_NOTE,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                },
                label = {Text(text = Constants.Keys.NOTE_TITLE)},
                isError = title.isEmpty()
            )

            OutlinedTextField(
                value = subtitle,
                onValueChange = {
                    subtitle = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                },
                label = {Text(text = Constants.Keys.NOTE_SUBTITLE)},
                isError = subtitle.isEmpty()
            )

            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addNote(note = Note(title = title, subtitle = subtitle)){
                        navController.navigate(NavRoute.Main.route)
                    }

                }
            ) {
                Text(
                    text = Constants.Keys.ADD_NOTE,
                    color = Color.White
                )
            }
        }
    }
}