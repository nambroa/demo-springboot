package com.springnotes.model.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @param title       The title of the note.
 * @param description The description of the note.
 */ // Class that models a received request to create a note.
public record CreateNoteRequest(String title, String description) {

    @JsonCreator
    public CreateNoteRequest(@JsonProperty(value = "title", required = true) String title,
                             @JsonProperty(value = "description") String description) {
        this.title = title;
        this.description = description;

    }
}
