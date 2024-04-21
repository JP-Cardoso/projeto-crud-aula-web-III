
# Projeto To-Do list de Tarefas

Projeto desenvolvido para o trabalho da disciplina de Web-III

Backend feito em Java Spring, com testes e Docker para criação de um banco de dados Postgres.


## Stack utilizada

**Banco de Dados:** Imagem docker

**Back-end:** Java Spring


## Instalação

Se você tiver o docker instalado na sua máquina basta rodar:
```bash
    docker-compose up -d
```
Esse comando irá subir um container com uma imagem do Postgres

Para rodar o projeto Spring, use:
```bash
    mvn spring-boot:run
```
Esse comando irá iniciar o servidor do Spring

### Observações
Caso não tenha o docker instalado, mas tenha o banco de dados instalado localmente, pode iniciar o projeto tranquilamente pois o projeto foi desenvolvido com migrations. Assim que o projeto for iniciado o Flyway irá criar a tabela.
    
