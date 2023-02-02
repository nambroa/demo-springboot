package com.springnotes.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Note not found")
public class NoteNotFoundException extends RuntimeException {
    /**
     * Id of the note that wasn't found.
     */
    private final String noteId;

    /**
     * Creates a new instance of {@link NoteNotFoundException}
     *
     * @param noteId Id of the note in question.
     */
    public NoteNotFoundException(String noteId) {
        super(String.format("Note not found for id %s.", noteId));
        this.noteId = noteId;
    }

    /**
     * Retrieves the field noteId.
     *
     * @return the value for the field noteId.
     */
    public String getNoteId() {
        return this.noteId;
    }
}
