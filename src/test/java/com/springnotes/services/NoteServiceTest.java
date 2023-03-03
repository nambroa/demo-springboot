package com.springnotes.services;


import com.springnotes.SpringNotesApplication;
import com.springnotes.model.api.CreateNoteRequest;
import com.springnotes.model.domain.Note;
import com.springnotes.repository.NoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SpringNotesApplication.class)
public class NoteServiceTest {

    private static final String NOTE_TITLE = "NoteTitle";

    private static final String NOTE_DESCRIPTION = "NoteDescription";


    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    private Note testNote;

    @Before
    public void setUp() {
        Note note = new Note("NoteTitle", "NoteDescription");
        Mockito.when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));
        Mockito.when(noteRepository.findAll()).thenReturn(List.of(note));

        testNote = note;
    }

    @Test
    public void givenExistingId_whenGettingOneNoteById_thenNoteShouldBeFound() {
        Optional<Note> note = noteService.getNote(String.valueOf(testNote.getId()));

        assert (note.isPresent());
        assertThat(note.get().getTitle()).isEqualTo(NOTE_TITLE);
        assertThat(note.get().getDescription()).isEqualTo(NOTE_DESCRIPTION);
    }

    @Test
    public void givenOneExistingNote_whenGettingAllNotes_thenNoteShouldBeFound() {
        List<Note> notes = noteService.getAllNotes();

        assertThat(notes).singleElement().isEqualTo(testNote);
    }

    @Test
    public void givenValidNoteCreation_whenCreatingNote_thenNoteShouldBeCreated() {
        Note note = noteService.createNote(new CreateNoteRequest("AnotherTitle", "AnotherDescription"));

        assertThat(note.getTitle()).isEqualTo("AnotherTitle");
        assertThat(note.getDescription()).isEqualTo("AnotherDescription");
    }
}
