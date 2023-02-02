package com.springnotes.services;

import com.springnotes.model.api.CreateNoteRequest;
import com.springnotes.model.domain.Note;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface NoteService {
    Note createNote(CreateNoteRequest createNoteRequest);

    List<Note> getAllNotes();

    Optional<Note> getNote(String noteId);
}
