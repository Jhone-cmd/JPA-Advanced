# JPA Advanced

Projeto de estudo em Java com Spring Boot e Spring Data JPA, focado em práticas avançadas de persistência, consultas customizadas e paginação de dados. Este projeto foi desenvolvido com base em aulas e conteúdos de estudo da plataforma RocketSeat, com foco em explorar recursos mais avançados do JPA e do Spring Data.

## Visão geral

O objetivo deste projeto é demonstrar como usar o Spring Data JPA de forma prática e eficiente em uma aplicação REST, com persistência em banco em memória H2, modelagem de entidade, filtros dinâmicos, paginação e estrutura de camada de serviço/repositório.

A aplicação simula um cadastro de pessoas com campos como nome, e-mail, data de nascimento, estado civil, cidade, UF, bairro e data de criação. A partir disso, é possível listar todos os registros e também buscar pessoas por critérios específicos com filtros combinados.

## Funcionalidades

- Cadastro de pessoas em banco em memória utilizando JPA
- Listagem completa de registros
- Busca com filtros dinâmicos por nome, e-mail, estado civil, cidade, estado, bairro e intervalo de datas
- Paginação e ordenação de resultados via `Pageable`
- Geração automática de identificadores UUID
- Persistência automática de data de criação com `@PrePersist`
- Console do banco H2 para consulta direta dos dados
- Estrutura organizada em camadas: controller, service, repository, specification, model, dto e seed

## Stack tecnológica

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Hibernate ORM
- H2 Database
- Lombok
- Spring Boot DevTools

## Bibliotecas e dependências principais

### Spring Boot starters

- `spring-boot-starter-data-jpa`: fornece a integração com JPA/Hibernate e o Spring Data repository
- `spring-boot-starter-webmvc`: permite a criação de endpoints REST com Spring MVC
- `spring-boot-devtools`: acelera o desenvolvimento com reinicialização automática e recursos úteis em dev
- `spring-boot-h2console`: habilita o console web do banco H2 para inspeção dos dados

### Banco de dados

- `com.h2database:h2`: banco em memória utilizado para facilitar testes e estudo local

### Utilidades

- `org.projectlombok:lombok`: reduz boilerplate em entidades e DTOs

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/
│   │   └── com/jhonecmd/jpa/advanced/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── seed/
│   │       ├── service/
│   │       ├── specification/
│   │       └── Application.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## Modelagem do domínio

A entidade principal é `PersonEntity`, mapeada com `@Entity` e anotada com `@Table(name = "persons")`.

### Campos principais

- `id`: identificador gerado automaticamente em UUID
- `name`: nome da pessoa
- `email`: email com restrição de unicidade
- `birthday`: data de aniversário
- `maritalStatus`: enum com estado civil
- `city`, `state`, `district`: dados de localização
- `createdAt`: data de criação preenchida automaticamente antes do persist

### Enum de estado civil

O projeto usa o enum `MaritalStatus`:

- `SINGLE`
- `MARRIED`
- `DIVORCED`
- `WIDOWED`

## Funcionalidades do Spring Data JPA presentes no projeto

### 1. `JpaRepository`

A interface `PersonRepository` herda de `JpaRepository<PersonEntity, UUID>`, o que fornece automaticamente operações básicas como:

- `save(...)`
- `saveAll(...)`
- `findById(...)`
- `findAll()`
- `delete(...)`
- `deleteAll()`
- `count()`

Essas funcionalidades já são implementadas pelo Spring Data sem a necessidade de escrever SQL manualmente.

### 2. `JpaSpecificationExecutor`

A repositório também estende `JpaSpecificationExecutor<PersonEntity>`, permitindo consultas dinâmicas e complexas via critérios JPA.

Isso é essencial para filtros combinados, como:

- nome parcial
- email parcial
- estado civil exato
- cidade
- estado
- bairro
- intervalo de datas de nascimento

### 3. `Specification`

A classe `PersonSpecification` encapsula a lógica de criação de filtros com `Specification<PersonEntity>`. Ela monta uma árvore de predicados com `CriteriaBuilder` para construir consultas dinâmicas com base nos parâmetros fornecidos.

Exemplos de filtros implementados:

- busca por nome com `LIKE`
- busca por e-mail com comparação em lowercase
- igualdade para `maritalStatus`
- busca por cidade e estado exatos
- busca por bairro com prefixo
- comparação de datas com `greaterThanOrEqualTo` e `lessThanOrEqualTo`

### 4. Paginação e ordenação

A aplicação usa `Pageable` e `Page<PersonEntity>` para retornar resultados paginados.

Isso é muito útil em aplicações reais, pois evita a recuperação de grandes quantidades de dados de uma vez. A rota `/persons/search` aceita parâmetros de paginação que podem ser configurados pela API cliente.

### 5. `@PrePersist`

A entidade `PersonEntity` usa o método `prePersist()` anotado com `@PrePersist` para preencher automaticamente `createdAt` antes de salvar a entidade.

Essa abordagem centraliza a lógica de controle de auditoria e evita que o campo seja preenchido manualmente em cada ponto da aplicação.

### 6. `@GeneratedValue(strategy = GenerationType.UUID)`

O identificador da entidade é gerado automaticamente como UUID. Isso é uma prática moderna para garantir identidade única e distribuída, sem depender de sequência numérica do banco.

### 7. `@Column(unique = true)`

O campo `email` recebe a anotação `@Column(unique = true)`, garantindo que não existam registros duplicados para o mesmo endereço de e-mail.

### 8. `CommandLineRunner` para seed de dados

A classe `SeedRunner` usa `CommandLineRunner` para popular automaticamente o banco com uma lista de pessoas quando a aplicação inicia. Isso ajuda no desenvolvimento e demonstra de forma prática como testar a aplicação sem precisar inserir dados manualmente.

## Endpoints da API

### Listar todos

```http
GET /persons
```

Retorna a lista completa de pessoas cadastradas.

### Buscar com filtros e paginação

```http
GET /persons/search
```

Parâmetros possíveis:

- `name`
- `email`
- `maritalStatus`
- `city`
- `state`
- `district`
- `initialBirthday`
- `finalBirthday`
- `page`
- `size`
- `sort`

Exemplo:

```http
GET /persons/search?name=ana&city=Sao%20Paulo&page=0&size=10
```

## Configuração do banco de dados

O projeto utiliza H2 em memória com a seguinte configuração em `application.properties`:

```properties
spring.application.name=jpa.advanced

spring.datasource.url=jdbc:h2:mem:jpa
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

Acesso ao console H2:

```text
http://localhost:8080/h2-console
```

## Como executar o projeto

### Pré-requisitos

- Java 21
- Maven

### Comandos

Na raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

Ou, se preferir:

```bash
mvn spring-boot:run
```

## Observações

Este projeto é um estudo prático sobre o uso avançado de Spring JPA/Data, com foco em:

- mapeamento de entidades
- persistência com Hibernate
- criação de repositórios
- filtros dinâmicos com Specifications
- paginação
- melhor organização da aplicação em camadas

## Créditos

Este projeto foi desenvolvido como parte de estudos e materiais de aprendizagem da plataforma RocketSeat, com foco em aprofundar os conceitos de Spring Data JPA e persistência em aplicações Java.
