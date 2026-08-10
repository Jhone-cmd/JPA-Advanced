package com.jhonecmd.jpa.advanced.service;

import com.jhonecmd.jpa.advanced.model.PersonEntity;
import com.jhonecmd.jpa.advanced.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonEntity> execute() {
        return  personRepository.findAll();
    }
}
