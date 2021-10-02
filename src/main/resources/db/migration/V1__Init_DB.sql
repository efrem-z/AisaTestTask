create sequence hibernate_sequence start 1 increment 1;


create table orders
(
    id int8 not null,
    date timestamp not null,
    service_type varchar(255) not null,
    user_id int8,
    primary key (id)
);

create table order_type
(
    id int8 not null,
    name varchar(255),
    primary key (id)
);

create table user_role
(
    user_id int8 not null,
    roles varchar(255)
);

create table usr
(
    id int8 not null,
    active boolean not null,
    email varchar(255),
    password varchar(255) not null ,
    phone_number varchar(255),
    username varchar(255) not null ,
    primary key (id)
);

alter table if exists orders add constraint orders_user_fk foreign key (user_id) references usr;

alter table if exists user_role add constraint user_role_user_fk foreign key (user_id) references usr;