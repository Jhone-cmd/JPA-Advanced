package com.jhonecmd.jpa.advanced.controller;

import com.jhonecmd.jpa.advanced.dto.PersonFilterDTO;
import com.jhonecmd.jpa.advanced.model.PersonEntity;
import com.jhonecmd.jpa.advanced.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonEntity>> getAll() {
       return ResponseEntity.ok(personService.execute());
    }

    @GetMapping("/search")
    public  ResponseEntity<Page<PersonEntity>> getAll(PersonFilterDTO filter, Pageable pageable) {
        return ResponseEntity.ok(personService.execute(filter, pageable));
    }
}
