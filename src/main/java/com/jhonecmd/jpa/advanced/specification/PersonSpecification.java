package com.jhonecmd.jpa.advanced.specification;

import com.jhonecmd.jpa.advanced.dto.PersonFilterDTO;
import com.jhonecmd.jpa.advanced.model.PersonEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonSpecification {

    public Specification<PersonEntity> persons(PersonFilterDTO filter) {
        return (root, query,criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };
    }
}
