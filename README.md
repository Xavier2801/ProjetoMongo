# 📦 Workshop MongoDB — API RESTful com Spring Boot

API RESTful desenvolvida com **Java + Spring Boot + MongoDB**, implementando um sistema de usuários e posts com operações completas de CRUD e consultas avançadas.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data MongoDB**
- **MongoDB**
- **Maven**

---

## 📁 Estrutura do Projeto

```
src/main/java/com/ruanxavier/workshopmongo/
├── config/
│   └── Instantiation.java         # Carga inicial de dados no banco
├── controller/
│   ├── UserController.java        # Endpoints de usuários
│   ├── PostController.java        # Endpoints de posts
│   └── exception/
│       ├── ControllerExceptionHandler.java
│       └── StandardError.java
├── domain/
│   ├── User.java                  # Entidade usuário
│   └── Post.java                  # Entidade post
├── dto/
│   ├── UserDTO.java               # DTO de usuário
│   └── AuthorDTO.java             # DTO de autor
├── repository/
│   ├── UserRepository.java
│   └── PostRepository.java
└── services/
    ├── UserService.java
    ├── PostService.java
    ├── URLService.java
    └── exception/
        └── ObjectNotFoundException.java
```

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java 17+](https://www.oracle.com/java/technologies/downloads/)
- [MongoDB](https://www.mongodb.com/try/download/community) rodando localmente na porta `27017`
- [Maven](https://maven.apache.org/) ou use o wrapper `./mvnw` incluso no projeto

---

## 🔧 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Xavier2801/ProjetoMongo.git
cd ProjetoMongo
```

2. Certifique-se de que o MongoDB está rodando:
```bash
mongod
```

3. Execute o projeto:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

> Ao iniciar, a classe `Instantiation` popula automaticamente o banco com dados de exemplo.

---

## 🗄️ Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=workshopmongo
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```

---

## 📌 Endpoints

### 👤 Usuários — `/users`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/users` | Lista todos os usuários |
| GET | `/users/{id}` | Busca usuário por ID |
| POST | `/users` | Cria um novo usuário |
| PUT | `/users/{id}` | Atualiza um usuário |
| DELETE | `/users/{id}` | Remove um usuário |
| GET | `/users/{id}/posts` | Lista posts de um usuário |

#### Exemplo — Criar usuário (POST `/users`)
```json
{
    "name": "Maria Brown",
    "email": "maria@gmail.com"
}
```

#### Exemplo — Atualizar usuário (PUT `/users/{id}`)
```json
{
    "name": "Maria Silva",
    "email": "mariasilva@gmail.com"
}
```

---

### 📝 Posts — `/posts`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/posts/{id}` | Busca post por ID |
| GET | `/posts/titlesearch?text=` | Busca posts pelo título |
| GET | `/posts/fullsearch` | Busca avançada com filtros |

#### Busca avançada (GET `/posts/fullsearch`)

Parâmetros de query:

| Parâmetro | Tipo | Descrição | Exemplo |
|-----------|------|-----------|---------|
| `text` | String | Texto a buscar no título, corpo ou comentários | `viagem` |
| `minDate` | String (yyyy-MM-dd) | Data mínima | `2018-01-01` |
| `maxDate` | String (yyyy-MM-dd) | Data máxima | `2018-12-31` |

Exemplo de requisição:
```
GET http://localhost:8080/posts/fullsearch?text=viagem&minDate=2018-01-01&maxDate=2018-12-31
```

---

## 🧱 Modelo de Dados

### User
```json
{
    "id": "string",
    "name": "string",
    "email": "string",
    "posts": []
}
```

### Post
```json
{
    "id": "string",
    "date": "date",
    "title": "string",
    "body": "string",
    "author": {
        "id": "string",
        "name": "string"
    },
    "comments": []
}
```

---

## ⚠️ Tratamento de Erros

A API retorna erros padronizados no seguinte formato:

```json
{
    "timestamp": 1234567890,
    "status": 404,
    "error": "Não encontrado",
    "message": "Objeto não encontrado",
    "path": "/users/id-inexistente"
}
```

| Status | Descrição |
|--------|-----------|
| 200 | Sucesso |
| 201 | Criado com sucesso |
| 204 | Sem conteúdo (delete/update) |
| 404 | Recurso não encontrado |
| 500 | Erro interno do servidor |

---

## 👨‍💻 Autor

Desenvolvido por **Ruan Xavier**

[![GitHub](https://img.shields.io/badge/GitHub-Xavier2801-181717?style=flat&logo=github)](https://github.com/Xavier2801)
