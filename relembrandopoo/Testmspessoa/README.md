--
# 👋 Olá, eu sou Albino Pires!

- 🌐 Cloud Enthusiast | AWS Cloud | Spring Boot | Linux | Java Development | Python
- 👨‍💻 BackEnd na GFT Brasil

## 🌐 Onde me encontrar

- [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/albino-pires-b188391b3/)
- [![Gmail](https://img.shields.io/badge/Gmail-333333?style=for-the-badge&logo=gmail&logoColor=red)](mailto:albinofp34@gmail.com)

---

# 📚 Estudo JAVA com Spring Boot 💻

🛠️ Tecnologias Utilizadas
- Resumo:

         ✅ Java 17 |✅ Spring Boot |✅ JUnit 5 |✅ Gradle |✅ IntelliJ IDEA |✅ Swagger |✅Insomnia

- 📄 Descrições:

  * 👨‍💻 Java: Linguagem principal utilizada para o desenvolvimento do projeto.

  * ⚙️ Spring Boot: Framework que agiliza o desenvolvimento de aplicações Java, facilitando a configuração e implementação.

  * 🧪 Mockito: Ferramenta para criação de testes unitários, garantindo a qualidade e a confiabilidade do código.

  * 📄 Swagger: Utilizado para documentar a API, fornecendo uma interface interativa para testes e navegação dos endpoints.

  * 🧪 Insomnia: Ferramenta usada para testar os endpoints da API de forma simples e eficaz.
---
⚙️ Funcionalidades 🔐
- Endpoints bem definidos e documentados no Swagger.

- Cobertura de testes unitários para validação da lógica de negócios.

- Arquitetura modular que permite manutenção e extensibilidade.

---
# 💻 MicroserviceComJAVAeTestUnitario
Microservices simples em JAVA com Spring Boot realizando um Teste Unitário Simples


---

## 📄 Estrutura do Projeto

```
Testmspessoa
├ .gradle
├ .idea
├ build
├ gradle
├ src
│  ├ main
│  │  ├ java
│  │  │  ├ com.estudos.testmspessoa
│  │  │  │  ├ controller
│  │  │  │  │  └ PessoaController.java
│  │  │  │  ├ dto
│  │  │  │  │  ├ ErroDTO.java
│  │  │  │  │  └ PessoaDTO.java
│  │  │  │  ├ exceptions
│  │  │  │  │  ├ CpfInvalidoException.java
│  │  │  │  │  ├ CpfJaCadastradoException.java
│  │  │  │  │  └ GlobalExceptionHandler.java
│  │  │  │  ├ model
│  │  │  │  │  └ Pessoa.java
│  │  │  │  ├ repository
│  │  │  │  │  └ PessoaRepository.java
│  │  │  │  └ TestmspessoaApplication.java
│  │  └ resources
│  │     ├ static
│  │     ├ templates
│  │     └ application.properties
│  └ test
│     └ java
│        └ com.estudos.testmspessoa
│            └ controller
│                └ PessoaControllerTest.java
├ build.gradle
├ deps.txt
├ .gitignore
```
## ✅ CRUD - Testando um cadastro:

* Realizando no browser com swagger: http://localhost:8080/swagger-ui/index.html#/ 
  * Realize a inserção de um nome e um cpf com nove dígitos;
  * Deve retornar um Status Code 201;

![Teste Unitário Executado com Sucesso](./images/post201.png)

---
## ✅ CRUD - Consultando cadastro:

* Realizando no browser com swagger: http://localhost:8080/swagger-ui/index.html#/
  * Realize um click na opção try out;
  * Deve retornar um Status Code 200;

![Teste Unitário Executado com Sucesso](./images/post200.png)


---


## 📄 Diagrama UML da Estrutura

![Diagrama UML do Projeto](./uml_microservice.png)

---

## 📄 Objetivo
Relembrar os conceitos de orientação a objetos e estruturas de projeto com Spring Boot, utilizando:
- Boas práticas de DTO e Exception
- Camadas bem definidas (Controller, Model, Repository)
- Testes unitários com foco no comportamento

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

---

## 🧪 Testando via Terminal

Você pode rodar os testes unitários diretamente no terminal:

```bash
./gradlew clean test
```

Ou, para compilar e executar o projeto:

```bash
./gradlew build
./gradlew bootRun
```

Para rodar com o wrapper no Windows:

```bash
gradlew.bat bootRun
```

---

## 🛠️ Requisições de Teste

Você pode testar os endpoints com ferramentas como **Postman** ou **Insomnia**.

**Exemplo de GET**:
```
GET http://localhost:8080/api/pessoas
```

**Exemplo de POST**:
```
POST http://localhost:8080/api/pessoas
Content-Type: application/json
{
  "nome": "Albino",
  "cpf": "12345678901"
}
```
## 🛠️Teste Unitário

- Os testes foram realizados com **JUnit 5**, focando na camada de `controller`.

  - **Print dos testes executados com sucesso:**

![Teste Unitário Executado com Sucesso](./images/TesteUnit.png)

---
