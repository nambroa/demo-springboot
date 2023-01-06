package com.springnotes.api;

import com.springnotes.model.api.CreateNoteRequest;
import com.springnotes.model.api.NoteDTO;
import com.springnotes.model.domain.Note;
import com.springnotes.services.NoteService;
import com.springnotes.transformer.NoteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    private final NoteTransformer noteTransformer;

    @Autowired
    public NoteController(NoteService noteService, NoteTransformer noteTransformer) {
        this.noteService = noteService;
        this.noteTransformer = noteTransformer;
    }

    // Creates a new note.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NoteDTO> create(CreateNoteRequest createNoteRequest) {
        Note note = noteService.createNote(createNoteRequest);
        NoteDTO noteDTO = this.noteTransformer.transform(note);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(noteDTO.id()).toUri();

        return ResponseEntity.created(location).body(noteDTO);
    }
}
