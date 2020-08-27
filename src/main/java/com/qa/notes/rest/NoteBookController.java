package com.qa.notes.rest;

import com.qa.notes.domain.Note;
import com.qa.notes.domain.NoteBook;
import com.qa.notes.service.NoteBookService;
import com.qa.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class NoteBookController {

    private final NoteBookService noteBookService;

    @Autowired
    public NoteBookController(NoteBookService noteBookService) {
        this.noteBookService = noteBookService;
    }

    @GetMapping("/getAllNoteBooks")
    public List<NoteBook> getAllNotes(){
        return this.noteBookService.readAllNoteBooks();
    }

    @PostMapping("/createNoteBook")
    public NoteBook createNoteBook(@RequestBody NoteBook noteBook){
        return this.noteBookService.createNoteBook(noteBook);
    }

    @DeleteMapping("/deleteNoteBook/{id}")
    public Boolean deleteNote(@PathVariable Long id){
        return this.noteBookService.deleteNoteBookById(id);
    }

//    @GetMapping("/getNoteById/{id}")
//    public Note getNoteById(@PathVariable Long id){
//        return this.noteService.findNoteById(id);
//    }
//
//    @PutMapping("/updateNote/{id}")
//    public Note updateNote(@PathVariable Long id, @RequestBody Note note){
//        return this.noteService.updateNote(id, note);
//    }
//
//    @PutMapping("/updateNoteWithPathParam")
//    public Note updateNoteWithPathParam(@PathParam("id") Long id, @RequestBody Note note){
//        // localhost:8080/updateNoteWithPathParam?id=1
//        return this.noteService.updateNote(id, note);
//    }

}
