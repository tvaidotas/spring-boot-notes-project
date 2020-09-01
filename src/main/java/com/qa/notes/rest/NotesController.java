package com.qa.notes.rest;

import com.qa.notes.domain.Note;
import com.qa.notes.dto.NoteDTO;
import com.qa.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class NotesController {

    private final NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<NoteDTO>> getAllNotes(){
        return ResponseEntity.ok(this.noteService.readAllNotes());
    }

    @PostMapping("/createNote")
    public ResponseEntity<NoteDTO> createNote(@RequestBody Note note){
        return new ResponseEntity<NoteDTO>(this.noteService.createNote(note), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id){
        return this.noteService.deleteNoteById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getNoteById/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id){
        return ResponseEntity.ok(this.noteService.findNoteById(id));

    }

    @PutMapping("/updateNote/{id}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @RequestBody Note note){
        return ResponseEntity.ok(this.noteService.updateNote(id, note));
    }

    @PutMapping("/updateNoteWithPathParam")
    public ResponseEntity<NoteDTO> updateNoteWithPathParam(@PathParam("id") Long id, @RequestBody Note note){
        // localhost:8080/updateNoteWithPathParam?id=1
        return ResponseEntity.ok(this.noteService.updateNote(id, note));
    }

}
