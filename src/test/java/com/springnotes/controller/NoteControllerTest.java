package com.springnotes.controller;


import com.springnotes.SpringNotesApplication;
import com.springnotes.model.api.CreateNoteRequest;
import com.springnotes.model.domain.Note;
import com.springnotes.services.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



/*
The integration tests need to start up a container to execute the test cases.
Hence, some additional setup is required for this — all of this is easy in Spring Boot.
 */

/*
We can use the webEnvironment attribute of @SpringBootTest to configure our runtime environment.
We're using WebEnvironment.MOCK here so that the container will operate in a mock servlet environment.

TestPropertySource allows us to create a different profile for integration tests, thus making its run separate from
other faster, smaller tests.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SpringNotesApplication.class)
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
@AutoConfigureMockMvc
public class NoteControllerTest {

    private static final String NOTE_TITLE = "NoteTitle";

    private static final String NOTE_DESCRIPTION = "NoteDescription";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private NoteService noteService;

    private Note testNote;

//    @Before
//    public void setUp() {
//        Note note = new Note("NoteTitle", "NoteDescription");
//        Mockito.when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));
//
//        testNote = note;
//    }

    @Test
    public void givenOneNote_whenGetAllNotesRequest_thenReturnThatNote() throws Exception {
        Note note = noteService.createNote(new CreateNoteRequest("AnotherTitle", "AnotherDescription"));

        mvc.perform(get("/api/notes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$[0].title", is("AnotherTitle")));
    }

}
