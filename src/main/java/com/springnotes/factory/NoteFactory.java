package com.springnotes.factory;

import com.springnotes.model.api.CreateNoteRequest;
import org.springframework.stereotype.Component;
import com.springnotes.model.domain.Note;

@Component
public class NoteFactory {

    public Note createFrom(CreateNoteRequest request){
        return new Note(request.title(), request.description());
    }
}
