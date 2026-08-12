package com.jhonecmd.jpa.advanced.repository;

import com.jhonecmd.jpa.advanced.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID>, JpaSpecificationExecutor<PersonEntity> {
}
