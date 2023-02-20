package com.kistasi.notes.feature_note.domain.use_case

import com.kistasi.notes.feature_note.domain.model.InvalidNoteException
import com.kistasi.notes.feature_note.domain.model.Note
import com.kistasi.notes.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("title is blank")
        }

        if (note.content.isBlank()) {
            throw InvalidNoteException("content is blank")
        }

        repository.insertNote(note)
    }
}
