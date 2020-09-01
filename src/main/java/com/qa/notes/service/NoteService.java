package com.qa.notes.service;

import com.qa.notes.domain.Note;
import com.qa.notes.dto.NoteDTO;
import com.qa.notes.exceptions.NoteNotFoundException;
import com.qa.notes.repo.NotesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NotesRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public NoteService(NotesRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private NoteDTO mapToDTO(Note note){
        return this.mapper.map(note, NoteDTO.class);
    }

    public List<NoteDTO> readAllNotes(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public NoteDTO createNote(Note note){
        return this.mapToDTO(this.repo.save(note));
    }

    public NoteDTO findNoteById(Long id){
        return this.mapToDTO(this.repo.findById(id)
                .orElseThrow(NoteNotFoundException::new));    }

    public NoteDTO updateNote(Long id, Note note){
        Note update = this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
        update.setTitle(note.getTitle());
        update.setDescription(note.getDescription());
        return this.mapToDTO(this.repo.save(note));
    }

    public Boolean deleteNoteById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
