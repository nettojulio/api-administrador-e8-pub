# EQUIPE 8 - Bola 8 - Desafio Final iLab

## API para autenticação de administradores

Uma aplicação em Java API para cadastro, autenticação e login de administradores (com os atributos: id, nome,
email e senha), além de validar o token JWT para consumo das outras duas APIs de usuários e pedidos.

Para ver o Front-end, clique aqui: 

Link do Jira: 

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu 
application.properties

`DB_URL`

`DB_USER`

`DB_PASSWORD`

## Instalação
Rodar no terminal
docker-compose up

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

#### Sucesso (200) ou Erro(400) Bad Request

| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `token` | `string` | token de acesso do usuario/entregador |


#### Exemplo
```http
{
	"token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJJdGFsb19Db3N0YSwyLGl
    0YWxvQGVtYWlsLmNvbSw3MTEyMzQ1Njc4OSIsImlzcyI6IkZvb2RMb3ZlcnMiLCJleHAi
    OjE2NDg3ODA4Nzl9.0UW7jMU8_S9VvluB3tMDvwRHAbp6ZcMoCoyFRrO6Udk"
}
```

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

#### Sucesso (200) ou Erro(400) Bad Request

#### Exemplo
```http
{
	"token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJJdGFsb19Db3N0YSwyLGl
    0YWxvQGVtYWlsLmNvbSw3MTEyMzQ1Njc4OSIsImlzcyI6IkZvb2RMb3ZlcnMiLCJleHAi
    OjE2NDg3ODA4Nzl9.0UW7jMU8_S9VvluB3tMDvwRHAbp6ZcMoCoyFRrO6Udk"
}
```

### Validar token

```http
  GET /validar
```

#### Dados Enviados

#### **No Body

#### Dados Recebidos

#### Sucesso (200), Erro(401) Não Autorizado
