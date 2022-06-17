create table if not exists administradores (
    id  serial not null,
    email varchar(50) not null unique,
    nome varchar(50) not null,
    senha TEXT not null,
    primary key (id)
);

insert into administradores (id, email, nome, senha) values (1, 'email@email.com', 'nome', '$2a$10$svvvIv8D1E3senrrkXUA8uKvwNMYwIfikad6ltKNnTAyCk6J6vkLq');