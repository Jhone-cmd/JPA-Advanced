package com.jhonecmd.jpa.advanced.service;

import com.jhonecmd.jpa.advanced.dto.PersonFilterDTO;
import com.jhonecmd.jpa.advanced.model.PersonEntity;
import com.jhonecmd.jpa.advanced.repository.PersonRepository;
import com.jhonecmd.jpa.advanced.specification.PersonSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonSpecification personSpecification;

    public List<PersonEntity> execute() {
        return personRepository.findAll();
    }

    public Page<PersonEntity> execute(PersonFilterDTO filter, Pageable pageable) {
        return personRepository.findAll(personSpecification.persons(filter), pageable);
    }
}