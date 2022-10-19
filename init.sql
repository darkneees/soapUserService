CREATE TABLE IF NOT EXISTS users (
    username varchar(80) primary key,
    first_name varchar(80) not null,
    second_name varchar(80) not null,
    age int not null,
    password varchar(256) not null
);

CREATE TABLE IF NOT EXISTS socials (
    id serial primary key,
    name_social varchar(80) NOT NULL,
    identifier_social varchar(80) NOT NULL,
    username varchar(80),
    constraint users_username_fk foreign key (username) references users (username)
);

CREATE TABLE IF NOT EXISTS roles (
    id int primary key,
    name_role varchar(80) NOT NULL,
    pretty_name_role varchar(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles (
    username varchar(80) not null,
    role_id int not null,
    PRIMARY KEY (username, role_id),
    constraint roles_id_fk foreign key (role_id)
        references roles (id),
    constraint users_id_fk foreign key (username)
        references users (username)
);