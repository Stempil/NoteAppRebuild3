package com.example.noteapprebuild3.db.repository

import androidx.lifecycle.LiveData
import com.example.noteapprebuild3.db.dao.NoteDao
import com.example.noteapprebuild3.model.NoteModel

class NoteRealization(private val noteDao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insertNote(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.deleteNote(noteModel)
        onSuccess()
    }

}