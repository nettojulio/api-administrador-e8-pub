# EQUIPE 8 - Bola 8 - Desafio Final iLab

## API de administradores

Uma aplicação Java API para cadastro, autenticação e login de administradores (com os atributos: id, nome,
email e senha), além de validar o token JWT para consumo das outras duas APIs de usuários e pedidos.

Repositório do Front-end, clique aqui: https://github.com/equipe8-final-ilab/frontend-e8
Repositório da API de usuários: https://github.com/equipe8-final-ilab/api-usuarios-e8
Repositório da API de pedidos: https://github.com/equipe8-final-ilab/api-pedidos-e8
Link do Jira: https://grupo8ilab.atlassian.net/jira/software/projects/G8ILAB/boards/2/roadmap
 

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu 
application.properties

`DB_URL`

`DB_USER`

`DB_PASSWORD`

## Instalação
Rodar no terminal
```
$ docker-compose up
```

## Autores

- [@JessieZan](https://www.github.com/JessieZan)
- [@nettojulio](https://www.github.com/nettojulio)
- [@Raphaella-leite](https://github.com/Raphaella-leite)
- [@queziabalonecker](https://github.com/queziabalonecker)
- [@Edvan-Jr](https://github.com/Edvan-Jr)
## Stack utilizada

**Front-end:** React.

**Back-end:** Java, SpringBoot, PostgreSQL, RDS, JWT, Bcrypt, Cors.


## Documentação da API

### End-Points

### Cadastro de Administradores

```http
  POST /admin
```

#### Dados Enviados

| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | nome do administrador **Obrigatório** |
| `email` | `string` | email do administrador **Obrigatório** |
| `senha` | `string` | senha do administrador **Obrigatório** |


#### Body
```http
{
	"nome":"admin",
	"email":"admin@email.com",
	"senha":"senhaqualquer"
}
```

#### Dados Recebidos

#### (201) Created ou Erro(400) Bad Request

---


### Login (Autenticação)

```http
  POST /login
```

#### Dados Enviados

| Chave   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email` | `string` | email do administrador **Obrigatório** |
| `senha` | `string` | senha do administrador **Obrigatório** |

#### Body
```http
{
	"email":"admin@email.com",
	"senha":"senhaqualquer"
}
```

#### Dados Recebidos

#### (200) OK ou Erro(400) Bad Request

#### Exemplo
```http
{
	"token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJJdGFsb19Db3N0YSwyLGl0YWxvQGVtYWlsLmNvbSw3MTEyMzQ1Njc4OSIsImlzcyI6IkZvb2RMb3ZlcnMiLCJleHAiOjE2NDg3ODA4Nzl9.0UW7jMU8_S9VvluB3tMDvwRHAbp6ZcMoCoyFRrO6Udk"
}
```

---


### Validar token

```http
  GET /validar
```

#### Dados Enviados

#### **No Body

#### Dados Recebidos

#### (204) No Content, Erro(401) Não Autorizado
