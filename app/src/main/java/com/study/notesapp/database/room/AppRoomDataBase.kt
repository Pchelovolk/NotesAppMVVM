package com.study.notesapp.database.room

import android.content.Context
import androidx.annotation.DisplayContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.study.notesapp.database.room.dao.NoteRoomDao
import com.study.notesapp.model.Note
import com.study.notesapp.utils.Constants.Keys.NOTE_DATABASE

@Database(entities = [Note::class], version = 1)
abstract class AppRoomDataBase : RoomDatabase(){

    abstract fun getRoomDao(): NoteRoomDao

    companion object{

        @Volatile
        private var INSTANCE: AppRoomDataBase? = null

        fun getInstance(context: Context): AppRoomDataBase{
            return if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDataBase::class.java,
                    NOTE_DATABASE
                ).build()
                INSTANCE as AppRoomDataBase
            }else INSTANCE as AppRoomDataBase
        }
    }
}