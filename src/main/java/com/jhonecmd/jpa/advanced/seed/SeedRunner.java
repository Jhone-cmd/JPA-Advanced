package com.jhonecmd.jpa.advanced.seed;

import com.jhonecmd.jpa.advanced.model.MaritalStatus;
import com.jhonecmd.jpa.advanced.model.PersonEntity;
import com.jhonecmd.jpa.advanced.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class SeedRunner {

    @Bean
    CommandLineRunner run(PersonRepository personRepository) {
        return args -> {

            List<PersonEntity> persons = List.of(
                    new PersonEntity(
                            "Ana Silva",
                            "ana.silva@gmail.com",
                            LocalDate.of(1995, 3, 15),
                            MaritalStatus.SINGLE,
                            "São Paulo",
                            "SP",
                            "Centro"
                    ),
                    new PersonEntity(
                            "Carlos Souza",
                            "carlos.souza@yahoo.com",
                            LocalDate.of(1988, 7, 22),
                            MaritalStatus.MARRIED,
                            "Rio de Janeiro",
                            "RJ",
                            "Copacabana"
                    ),
                    new PersonEntity(
                            "Mariana Oliveira",
                            "mariana.oli@hotmail.com",
                            LocalDate.of(1992, 11, 5),
                            MaritalStatus.SINGLE,
                            "Belo Horizonte",
                            "MG",
                            "Savassi"
                    ),
                    new PersonEntity(
                            "Lucas Almeida",
                            "lucas.almeida@outlook.com",
                            LocalDate.of(1985, 1, 30),
                            MaritalStatus.DIVORCED,
                            "Curitiba",
                            "PR",
                            "Batel"
                    ),
                    new PersonEntity(
                            "Beatriz Costa",
                            "bia.costa@gmail.com",
                            LocalDate.of(1998, 9, 12),
                            MaritalStatus.SINGLE,
                            "Florianópolis",
                            "SC",
                            "Trindade"
                    ),
                    new PersonEntity(
                            "Gabriel Santos",
                            "gabriel.santos@empresa.com",
                            LocalDate.of(1990, 6, 18),
                            MaritalStatus.MARRIED,
                            "Porto Alegre",
                            "RS",
                            "Moinhos de Vento"
                    ),
                    new PersonEntity(
                            "Juliana Lima",
                            "juliana.lima@gmail.com",
                            LocalDate.of(1993, 12, 3),
                            MaritalStatus.SINGLE,
                            "Brasília",
                            "DF",
                            "Asa Sul"
                    ),
                    new PersonEntity(
                            "Rafael Rocha",
                            "rafael.rocha@uol.com.br",
                            LocalDate.of(1987, 4, 10),
                            MaritalStatus.MARRIED,
                            "Salvador",
                            "BA",
                            "Pituba"
                    ),
                    new PersonEntity(
                            "Camila Mendes",
                            "camila.mendes@gmail.com",
                            LocalDate.of(1996, 8, 25),
                            MaritalStatus.SINGLE,
                            "Recife",
                            "PE",
                            "Boa Viagem"
                    ),
                    new PersonEntity(
                            "Bruno Cardoso",
                            "bruno.cardoso@yahoo.com",
                            LocalDate.of(1991, 2, 14),
                            MaritalStatus.SINGLE,
                            "Fortaleza",
                            "CE",
                            "Meireles"
                    ),
                    new PersonEntity(
                            "Larissa Ribeiro",
                            "larissa.ribeiro@outlook.com",
                            LocalDate.of(1994, 10, 19),
                            MaritalStatus.MARRIED,
                            "Goiânia",
                            "GO",
                            "Bueno"
                    ),
                    new PersonEntity(
                            "Thiago Martins",
                            "thiago.martins@gmail.com",
                            LocalDate.of(1983, 5, 8),
                            MaritalStatus.DIVORCED,
                            "Manaus",
                            "AM",
                            "Adrianópolis"
                    ),
                    new PersonEntity(
                            "Fernanda Dias",
                            "fernanda.dias@hotmail.com",
                            LocalDate.of(1997, 1, 27),
                            MaritalStatus.SINGLE,
                            "Vitória",
                            "ES",
                            "Praia do Canto"
                    ),
                    new PersonEntity(
                            "Rodrigo Barbosa",
                            "rodrigo.barbosa@empresa.com",
                            LocalDate.of(1989, 9, 30),
                            MaritalStatus.MARRIED,
                            "Belém",
                            "PA",
                            "Umarizal"
                    )
            );
            personRepository.saveAll(persons);
        };
    }
}
