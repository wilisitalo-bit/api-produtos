# 🛒 API Produtos

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de produtos, utilizando **MySQL** como banco de dados e **Spring Data JPA/Hibernate** para persistência.

O projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento backend, criação de APIs REST, integração com banco de dados, operações CRUD, validação de dados, tratamento de exceções e versionamento com Git/GitHub.

---

## 🚀 Tecnologias utilizadas

* **Java 21**
* **Spring Boot 4.1.1**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **MySQL 8**
* **Maven**
* **Git**
* **GitHub**
* **Postman**

---

## 📌 Funcionalidades

A API permite realizar as principais operações de gerenciamento de produtos:

* ✅ Cadastrar produto
* ✅ Listar todos os produtos
* ✅ Buscar produto por ID
* ✅ Atualizar produto
* ✅ Excluir produto
* ✅ Consultar quantidade de produtos
* ✅ Validação dos dados recebidos
* ✅ Tratamento de erros e exceções
* ✅ Persistência dos dados em banco MySQL
* ✅ Geração automática dos IDs dos produtos

---

## 🏗️ Arquitetura do projeto

O projeto utiliza uma separação de responsabilidades entre as principais camadas da aplicação:

```text
src
└── main
    ├── java
    │   └── com.example.demo
    │       ├── ApiProdutosApplication.java
    │       ├── Produto.java
    │       ├── ProdutoController.java
    │       ├── ProdutoService.java
    │       ├── ProdutoRepository.java
    │       ├── ProdutoNotFoundException.java
    │       └── GlobalExceptionHandler.java
    │
    └── resources
        └── application.properties
```

### Controller

`ProdutoController`

Responsável por receber as requisições HTTP e disponibilizar os endpoints da API.

### Service

`ProdutoService`

Responsável pela lógica de negócio da aplicação.

### Repository

`ProdutoRepository`

Responsável pela comunicação entre a aplicação e o banco de dados utilizando **Spring Data JPA**.

### Entity

`Produto`

Representa a entidade produto armazenada no banco de dados.

### Exception

`ProdutoNotFoundException`

Exceção utilizada quando um produto solicitado não é encontrado.

### Global Exception Handler

`GlobalExceptionHandler`

Responsável pelo tratamento centralizado das exceções e erros de validação da API.

---

# 🗄️ Banco de dados

O projeto utiliza **MySQL** para armazenamento dos produtos.

Banco utilizado:

```text
api_produtos
```

A aplicação utiliza o Hibernate/JPA para realizar o mapeamento entre a entidade Java e a tabela do banco.

O ID dos produtos é gerado automaticamente pelo banco de dados.

### Configuração

As informações de conexão ficam no arquivo:

```text
src/main/resources/application.properties
```

A senha do banco **não é armazenada diretamente no código**.

A aplicação utiliza uma variável de ambiente:

```properties
spring.datasource.password=${DB_PASSWORD}
```

Dessa forma, a senha do banco não precisa ser publicada no GitHub.

---

# 🔐 Variável de ambiente

Para executar o projeto localmente, é necessário configurar a variável:

```text
DB_PASSWORD
```

No Windows PowerShell:

```powershell
[Environment]::SetEnvironmentVariable("DB_PASSWORD", "SUA_SENHA", "User")
```

Depois de configurar a variável, reinicie a IDE para que a aplicação reconheça a alteração.

> Substitua `SUA_SENHA` pela senha utilizada no seu MySQL.

---

# ⚙️ Configuração do banco

Antes de executar a aplicação, tenha o MySQL instalado e em execução.

Crie o banco de dados:

```sql
CREATE DATABASE api_produtos;
```

A aplicação está configurada para utilizar:

```text
Host: localhost
Porta: 3306
Banco: api_produtos
Usuário: root
```

A senha deve ser fornecida através da variável de ambiente `DB_PASSWORD`.

---

# ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone URL_DO_SEU_REPOSITORIO
```

Entre na pasta:

```bash
cd api-produtos
```

### 2. Configure o banco de dados

Certifique-se de que o MySQL esteja funcionando e que o banco `api_produtos` exista.

### 3. Configure a senha do MySQL

No Windows PowerShell:

```powershell
[Environment]::SetEnvironmentVariable("DB_PASSWORD", "SUA_SENHA", "User")
```

### 4. Execute a aplicação

O projeto utiliza Maven.

No Windows:

```powershell
.\mvnw spring-boot:run
```

Ou execute a classe:

```text
ApiProdutosApplication.java
```

pela IDE.

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

# 📡 Endpoints

## Listar produtos

```http
GET /produtos
```

Retorna todos os produtos cadastrados.

### Exemplo

```http
GET http://localhost:8080/produtos
```

---

## Buscar produto por ID

```http
GET /produtos/{id}
```

### Exemplo

```http
GET http://localhost:8080/produtos/1
```

---

## Consultar quantidade de produtos

```http
GET /produtos/quantidade
```

### Exemplo

```http
GET http://localhost:8080/produtos/quantidade
```

---

## Cadastrar produto

```http
POST /produtos
```

### Exemplo de requisição

```json
{
    "nome": "Notebook",
    "preco": 3500
}
```

O ID é gerado automaticamente pelo banco de dados.

---

## Atualizar produto

```http
PUT /produtos/{id}
```

### Exemplo

```http
PUT http://localhost:8080/produtos/1
```

```json
{
    "nome": "Notebook Gamer",
    "preco": 4500
}
```

---

## Excluir produto

```http
DELETE /produtos/{id}
```

### Exemplo

```http
DELETE http://localhost:8080/produtos/1
```

---

# ✅ Validação

A API possui validações utilizando Bean Validation.

Por exemplo, o nome do produto não pode estar vazio e o preço deve ser positivo.

Exemplo de requisição inválida:

```json
{
    "nome": "",
    "preco": -100
}
```

A aplicação identifica os campos inválidos e retorna uma resposta informando os erros encontrados.

---

# ❌ Tratamento de exceções

A API possui tratamento centralizado de exceções através do:

```text
GlobalExceptionHandler
```

Quando um produto não é encontrado, a aplicação utiliza:

```text
ProdutoNotFoundException
```

Isso permite retornar respostas HTTP apropriadas ao cliente em vez de deixar a exceção chegar diretamente ao usuário.

---

# 🧪 Testes com Postman

Durante o desenvolvimento, os endpoints foram testados utilizando o **Postman**.

Foram realizados testes para:

* GET de todos os produtos
* GET por ID
* POST
* PUT
* DELETE
* Consulta de quantidade
* Validação de dados
* Tratamento de produto inexistente

---

# 📚 Conceitos praticados

Este projeto foi desenvolvido como prática de conceitos fundamentais de desenvolvimento backend:

* Java
* Programação Orientada a Objetos
* Spring Boot
* APIs REST
* HTTP
* CRUD
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Injeção de dependências
* Arquitetura em camadas
* Validação de dados
* Tratamento de exceções
* Variáveis de ambiente
* Git
* GitHub
* Testes de API com Postman

---

# 🔄 Evolução do projeto

O projeto começou utilizando armazenamento temporário em memória.

Posteriormente, foi realizada a integração com MySQL utilizando JPA/Hibernate.

A evolução foi:

```text
Lista em memória
      ↓
Spring Data JPA
      ↓
MySQL
      ↓
CRUD persistente
      ↓
IDs automáticos
      ↓
Tratamento de exceções
      ↓
Validação
      ↓
Git
      ↓
GitHub
```

---

# 🎯 Objetivo

Este projeto faz parte do meu processo de aprendizado em desenvolvimento backend com Java.

O objetivo é evoluir gradualmente a aplicação, adicionando novos conceitos e boas práticas utilizadas no desenvolvimento de APIs profissionais.

---

# 🔮 Próximas melhorias

Algumas funcionalidades que podem ser adicionadas futuramente:

* [ ] Documentação com Swagger/OpenAPI
* [ ] Testes unitários
* [ ] Testes de integração
* [ ] DTOs
* [ ] Paginação
* [ ] Ordenação e filtros
* [ ] Autenticação e autorização
* [ ] Spring Security
* [ ] Melhorias no tratamento de erros
* [ ] Docker
* [ ] Deploy da aplicação
* [ ] CI/CD

---

## 👨‍💻 Desenvolvido por

**Wilis Italo**

Projeto desenvolvido para estudos e prática de desenvolvimento backend com Java e Spring Boot.
