package com.qa.notes.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The note with this id doesn't exist")
public class NoteNotFoundException extends EntityNotFoundException {
}
