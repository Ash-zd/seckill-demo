create table `order`
(
    index_code  varchar(48) not null,
    customer_id int         null,
    store_id    int         null,
    created_at  timestamp   not null,
    updated_at  timestamp   not null,
    constraint order_index_code_uindex
        unique (index_code)
);

alter table `order`
    add primary key (index_code);

create table order_detail
(
    id               int auto_increment
        primary key,
    order_index_code varchar(48)    not null,
    product_id       int            not null,
    price            decimal(19, 2) not null,
    created_at       timestamp      not null,
    updated_at       timestamp      not null
);

create table product
(
    id          int auto_increment
        primary key,
    store_id    int            not null,
    name        varchar(128)   null,
    description varchar(512)   null,
    price       decimal(19, 2) null,
    tag         varchar(128)   null,
    created_at  timestamp      not null,
    updated_at  timestamp      not null
);

create table store
(
    id          int auto_increment
        primary key,
    owner_id    int          not null,
    name        varchar(128) null,
    description varchar(512) null,
    created_at  timestamp    not null,
    updated_at  timestamp    not null
);

create table user
(
    id       int auto_increment
        primary key,
    username varchar(48)          not null,
    password varchar(128)         not null,
    email    varchar(50)          null,
    is_user  tinyint(1) default 1 not null,
    constraint user_username_uindex
        unique (username)
);

