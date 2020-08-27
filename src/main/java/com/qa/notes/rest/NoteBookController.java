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
    public List<NoteBook> getAllNoteBooks(){
        return this.noteBookService.readAllNoteBooks();
    }

    @PostMapping("/createNoteBook")
    public NoteBook createNoteBook(@RequestBody NoteBook noteBook){
        return this.noteBookService.createNoteBook(noteBook);
    }

    @DeleteMapping("/deleteNoteBook/{id}")
    public Boolean deleteNoteBooks(@PathVariable Long id){
        return this.noteBookService.deleteNoteBookById(id);
    }

    @GetMapping("/getNoteBookById/{id}")
    public NoteBook getNoteBookById(@PathVariable Long id){
        return this.noteBookService.findNoteBookById(id);
    }

    @PutMapping("/updateNoteBook/{id}")
    public NoteBook updateNoteBook(@PathVariable Long id, @RequestBody NoteBook noteBook){
        return this.noteBookService.updateNoteBook(id, noteBook);
    }

}
