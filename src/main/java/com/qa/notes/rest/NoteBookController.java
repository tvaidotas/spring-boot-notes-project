package com.qa.notes.rest;

import com.qa.notes.domain.NoteBook;
import com.qa.notes.dto.NoteBookDTO;
import com.qa.notes.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteBookController {

    private final NoteBookService noteBookService;

    @Autowired
    public NoteBookController(NoteBookService noteBookService) {
        this.noteBookService = noteBookService;
    }

    @GetMapping("/getAllNoteBooks")
    public ResponseEntity<List<NoteBookDTO>> getAllNoteBooks(){
        return ResponseEntity.ok(this.noteBookService.readAllNoteBooks());
    }

    @PostMapping("/createNoteBook")
    public ResponseEntity<NoteBookDTO> createNoteBook(@RequestBody NoteBook noteBook){
        return new ResponseEntity<NoteBookDTO>(this.noteBookService.createNoteBook(noteBook), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteNoteBook/{id}")
    public Boolean deleteNoteBooks(@PathVariable Long id){
        return this.noteBookService.deleteNoteBookById(id);
    }

    @GetMapping("/getNoteBookById/{id}")
    public ResponseEntity<NoteBookDTO> getNoteBookById(@PathVariable Long id){
        return ResponseEntity.ok(this.noteBookService.findNoteBookById(id));
    }

    @PutMapping("/updateNoteBook/{id}")
    public ResponseEntity<NoteBookDTO> updateNoteBook(@PathVariable Long id, @RequestBody NoteBook noteBook){
        return ResponseEntity.ok(this.noteBookService.updateNoteBook(id, noteBook));
    }

}
