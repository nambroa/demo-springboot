package com.springnotes.controller;



import com.springnotes.SpringNotesApplication;
import com.springnotes.model.domain.Note;
import com.springnotes.repository.NoteRepository;
import com.springnotes.services.NoteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

/*
The integration tests need to start up a container to execute the test cases.
Hence, some additional setup is required for this — all of this is easy in Spring Boot.
 */

/*
We can use the webEnvironment attribute of @SpringBootTest to configure our runtime environment.
We're using WebEnvironment.MOCK here so that the container will operate in a mock servlet environment.


 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SpringNotesApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
public class NoteControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Before
    public void setUp(){
        Note note = new Note("Title", "Description");

        Mockito.when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));

    }
    @Test
    public void nothingTest(){
        assert true;
    }
}
