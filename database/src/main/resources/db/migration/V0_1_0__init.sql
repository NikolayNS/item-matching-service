create table if not exists company
(
    id             bigint       not null
        constraint company_pkey
            primary key,
    name           varchar      not null,
    company_type   varchar      not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

create table if not exists brand_name
(
    id             bigint       not null
        constraint brand_name_pkey
            primary key,
    name           varchar      not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

create table if not exists modified_string
(
    id             bigint       not null
        constraint modified_string_pkey
            primary key,
    modifiable     varchar      not null,
    modifying      varchar      not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

create table if not exists reference
(
    id             bigint       not null
        constraint reference_pkey
            primary key,
    name           varchar      not null,
    reference_type varchar      not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

create table if not exists reference_field
(
    id             bigint       not null
        constraint reference_field_pkey
            primary key,
    barcode        varchar      not null,
    name           varchar      not null,
    reference_id   bigint       not null
        constraint reference_field_reference_id_fkey
            references reference,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

create table if not exists price
(
    id             bigint       not null
        constraint price_pkey
            primary key,
    cost           numeric      not null,
    currency       currency     not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

CREATE TABLE IF NOT EXISTS item
(
    id                 bigint    not null
        constraint item_pkey
            primary key,
    barcode            varchar,
    name               varchar   not null,
    price_id           bigint
        constraint item_price_id_fkey
            references price,
    item_type          varchar   not null,
    company_id         bigint
        constraint item_cimpany_id_fkey
            references company,
    brand_id           bigint
        constraint item_brand_id_fkey
            references brand,
    reference_field_id bigint
        constraint item_reference_field_id_fkey
            references reference_field,
    created_at         timestamp not null,
    updated_at         timestamp not null
);

CREATE TABLE IF NOT EXISTS user
(
    id         bigint           not null
        constraint user_pkey
            primary key,
    name           varchar      not null,
    email          varchar,
    user_type      varchar      not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

CREATE TABLE IF NOT EXISTS task_property
(
    id         bigint           not null
        constraint task_property_pkey
            primary key,
    path           varchar      not null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

CREATE TABLE IF NOT EXISTS task
(
    id         bigint           not null
        constraint task_pkey
            primary key,
    user_id         bigint      not null
        constraint task_user_id_fkey
            references user,
    task_type      varchar      not null,
    task_property_id bigint     not null
        constraint task_task_property_id_fkey
            references task_property,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);