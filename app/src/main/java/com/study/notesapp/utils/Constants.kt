package com.study.notesapp.utils

import com.study.notesapp.database.DataBaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY : DataBaseRepository

object Constants {

    object Keys{

        const val NOTE_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"

        const val ADD_NEW_NOTE = "Add new  NOTE"
        const val NOTE_TITLE = "Note title"
        const val NOTE_SUBTITLE = "Note SUB"
        const val ADD_NOTE = "ADD NOTE"

        const val TITLE = "Title"
        const val SUBTITLE = "SubTitle"

        const val USAGE = "What will we USE?"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "FireBase database"

        const val ID = "ID"
        const val NONE = "none"

        const val UPDATE = "UPDATE"
        const val DELETE = "DELETE"
        const val NAV_BACK = "BACK"

        const val EDIT_NOTE = "Edit_note"
        const val EMPTY = ""
        const val UPDATE_NOTE = "Update note"
    }

    object Screens{
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val NOTE_SCREEN = "note_screen"
    }
}