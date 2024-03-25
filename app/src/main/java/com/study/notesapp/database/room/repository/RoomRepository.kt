package com.study.notesapp.database.room.repository

import androidx.lifecycle.LiveData
import com.study.notesapp.database.DataBaseRepository
import com.study.notesapp.database.room.dao.NoteRoomDao
import com.study.notesapp.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DataBaseRepository{
    override val readAll: LiveData<List<Note>>

        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
        onSuccess()

    }

    override fun signOut() {}
}