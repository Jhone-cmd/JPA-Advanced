package com.jhonecmd.jpa.advanced.controller;

import com.jhonecmd.jpa.advanced.model.PersonEntity;
import com.jhonecmd.jpa.advanced.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    public ResponseEntity<List<PersonEntity>> getAll() {
       return ResponseEntity.ok(personService.execute());
    }
}
