package com.jhonecmd.jpa.advanced.repository;

import com.jhonecmd.jpa.advanced.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
