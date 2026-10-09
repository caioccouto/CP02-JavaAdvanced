# Sistema de Cursos — API REST

API REST desenvolvida em Java com Spring Boot para o gerenciamento de um catálogo de cursos e seus respectivos módulos. O projeto aplica conceitos de desenvolvimento backend, persistência de dados, validação de informações e tratamento global de exceções.

## Tecnologias utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **H2 Database**
* **Bean Validation**
* **Maven**
* **Lombok**

## Funcionalidades

* Cadastro, consulta, atualização e exclusão de cursos.
* Cadastro e consulta de módulos associados a cursos.
* Relacionamento um-para-muitos (1:N) entre cursos e módulos.
* Paginação na listagem de cursos e módulos.
* Validação dos dados recebidos nas requisições.
* Validação personalizada para garantir que a carga horária dos módulos seja múltipla de 5.
* Tratamento global de exceções com respostas HTTP adequadas.
* Utilização de DTOs para separar as entidades internas dos dados expostos pela API.

## Arquitetura

O projeto utiliza uma arquitetura em camadas para organizar as responsabilidades da aplicação:

* **Controller:** recebe e processa as requisições HTTP.
* **Service:** concentra a lógica de negócio.
* **Repository:** realiza as operações de persistência utilizando Spring Data JPA.
* **DTO:** define os dados de entrada e saída da API.
* **Mapper:** realiza a conversão entre entidades e DTOs.
* **Validation:** contém as regras de validação personalizadas.
* **Exceptions:** reúne as exceções customizadas.
* **Configurations:** contém o tratamento global de exceções.

## Executando o projeto

**Pré-requisitos:** Java 21 e Git.

1. Clone o repositório:

   ```bash
   git clone https://github.com/caioccouto/CP02-JavaAdvanced.git
   ```

2. Entre na pasta do projeto:

   ```bash
   cd sistema-cursos
   ```

3. Execute a aplicação:

   ```bash
   ./mvnw spring-boot:run
   ```

   No Windows, utilize:

   ```bash
   mvnw.cmd spring-boot:run
   ```

## Endpoints principais

| Método | Endpoint                        | Descrição                    |
| ------ | ------------------------------- | ---------------------------- |
| POST   | `/api/cursos`                   | Cadastrar curso              |
| GET    | `/api/cursos`                   | Listar cursos com paginação  |
| GET    | `/api/cursos/{id}`              | Consultar curso por ID       |
| PUT    | `/api/cursos/{id}`              | Atualizar curso              |
| DELETE | `/api/cursos/{id}`              | Excluir curso                |
| GET    | `/api/cursos/{cursoId}/modulos` | Listar módulos de um curso   |
| POST   | `/api/cursos/{cursoId}/modulos` | Cadastrar módulo em um curso |
| GET    | `/api/modulos/{id}`             | Consultar módulo por ID      |
| DELETE | `/api/modulos/{id}`             | Excluir módulo               |

A paginação pode ser configurada por meio dos parâmetros `page` e `size`.

## Banco de dados

A aplicação utiliza o H2 Database em memória, com configuração para criação e atualização do esquema via Hibernate. O console do banco pode ser acessado em:

`http://localhost:8080/h2-console`

## Objetivo

Consolidar conhecimentos de desenvolvimento de APIs REST com Java e Spring Boot, aplicando persistência com JPA, relacionamentos entre entidades, arquitetura em camadas, validação de dados, paginação e tratamento de erros.

---

Desenvolvido como projeto acadêmico da disciplina Java Advanced — FIAP.
