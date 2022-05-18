create table if not exists j_role (
    id serial primary key,
    name varchar(2000)
);

create table if not exists j_user (
    id serial primary key,
    name varchar(2000),
    role_id int not null references j_role(id)
);

create table role_o (
    id serial primary key,
    name varchar(2000)
);

create table user_o (
    id serial primary key,
    name varchar(2000)
);

create table mark_car (
    id serial primary key,
    name varchar(2000)
);

create table model_car (
    id serial primary key,
    name varchar(2000)
);

create table if not exists persons (
    id serial primary key,
    name varchar(2000)
);

create table if not exists addresses (
    id serial primary key,
    street varchar(2000),
	number varchar(2000)
);

create table if not exists author (
    id serial primary key,
    name varchar(2000)
);

create table if not exists book (
    id serial primary key,
    name varchar(2000)
);