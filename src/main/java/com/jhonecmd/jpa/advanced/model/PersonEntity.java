package com.jhonecmd.jpa.advanced.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @Column(unique = true)
    private  String email;

    private LocalDate birthday;
    private MaritalStatus maritalStatus;
    private String city;
    private String state;
    private String district;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PersonEntity(String name, String email, LocalDate birthday, MaritalStatus maritalStatus, String city, String state, String district) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.maritalStatus = maritalStatus;
        this.city = city;
        this.state = state;
        this.district = district;

    }

    @PrePersist
    private void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
