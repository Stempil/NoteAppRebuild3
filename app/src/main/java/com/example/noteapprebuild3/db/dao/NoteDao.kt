package com.example.noteapprebuild3.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapprebuild3.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteModel: NoteModel)

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)

    @Query("Select * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

}