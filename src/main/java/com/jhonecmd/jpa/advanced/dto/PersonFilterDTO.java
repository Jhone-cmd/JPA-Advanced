package com.jhonecmd.jpa.advanced.dto;

import com.jhonecmd.jpa.advanced.model.MaritalStatus;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PersonFilterDTO {

    private String name;
    private  String email;
    private MaritalStatus maritalStatus;
    private String city;
    private String state;
    private String district;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate initialBirthday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finalBirthday;
}
