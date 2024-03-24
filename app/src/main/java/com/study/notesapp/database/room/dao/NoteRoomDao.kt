package com.study.notesapp.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.study.notesapp.model.Note

@Dao
interface NoteRoomDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNotes() : LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}