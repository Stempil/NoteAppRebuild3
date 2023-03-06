package com.example.noteapprebuild3.db.repository

import androidx.lifecycle.LiveData
import com.example.noteapprebuild3.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)

}