package com.qa.notes.service;

import com.qa.notes.repo.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteBookService {

    private final NoteBookRepository repo;

    @Autowired
    public NoteBookService(NoteBookRepository repo) {
        this.repo = repo;
    }





}
