package com.qa.notes.rest;

import com.qa.notes.domain.Note;
import com.qa.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotesController {

    private final NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public List<Note> getAllNotes(){
        return this.noteService.readAllNotes();
    }

    @PostMapping("/createNote")
    public Note createNote(@RequestBody Note note){
        return this.noteService.createNote(note);
    }

}
