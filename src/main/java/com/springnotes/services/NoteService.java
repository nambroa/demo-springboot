package com.springnotes.services;

import com.springnotes.factory.NoteFactory;
import com.springnotes.model.api.CreateNoteRequest;
import com.springnotes.model.domain.Note;
import com.springnotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteService {

    private final NoteRepository noteRepository;

    private final NoteFactory noteFactory;


    @Autowired
    public NoteService(NoteRepository noteRepository, NoteFactory noteFactory) {
        this.noteRepository = noteRepository;
        this.noteFactory = noteFactory;
    }

    public Note createNote(CreateNoteRequest createNoteRequest) {
        Note note =  this.noteFactory.createFrom(createNoteRequest);
        this.noteRepository.save(note);
        return note;
    }
}