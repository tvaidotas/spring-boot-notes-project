package com.qa.notes.service;

import com.qa.notes.domain.Note;
import com.qa.notes.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NotesRepository repo;

    @Autowired
    public NoteService(NotesRepository repo) {
        this.repo = repo;
    }

    public List<Note> readAllNotes(){
        return this.repo.findAll();
    }

    public Note createNote(Note note){
        return this.repo.save(note);
    }

    public Note findNoteById(Long id){
        return this.repo.findById(id).orElseThrow();
    }

}
