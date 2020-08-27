package com.qa.notes.service;

import com.qa.notes.domain.NoteBook;
import com.qa.notes.dto.NoteBookDTO;
import com.qa.notes.exceptions.NoteBookNotFoundException;
import com.qa.notes.exceptions.NoteNotFoundException;
import com.qa.notes.repo.NoteBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteBookService {

    private final NoteBookRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public NoteBookService(NoteBookRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private NoteBookDTO mapToDTO(NoteBook noteBook){
        return this.mapper.map(noteBook, NoteBookDTO.class);
    }

    public List<NoteBookDTO> readAllNoteBooks(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public NoteBookDTO createNoteBook(NoteBook noteBook){
        return this.mapToDTO(this.repo.save(noteBook));
    }

    public NoteBookDTO findNoteBookById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(NoteBookNotFoundException::new));
    }

    public NoteBookDTO updateNoteBook(Long id, NoteBook noteBook){
        NoteBook update = this.repo.findById(id).orElseThrow(NoteBookNotFoundException::new);
        update.setName(noteBook.getName());
        return this.mapToDTO(this.repo.save(update));
    }

    public Boolean deleteNoteBookById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
