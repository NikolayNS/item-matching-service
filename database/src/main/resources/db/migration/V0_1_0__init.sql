create table if not exists company
(
    id             bigint        not null
        constraint company_pkey
            primary key,
    created_at     timestamp    not null,
    updated_at     timestamp    not null,
);

create table if not exists miniapps
(
    id         varchar(255) not null
        constraint miniapps_pkey
            primary key,
    created_at timestamp    not null,
    is_delete  boolean      not null,
    deleted_at timestamp,
    updated_at timestamp    not null
);


create table if not exists categories
(
    id         bigint       not null
        constraint categories_pkey
            primary key,
    created_at timestamp    not null,
    is_delete  boolean      not null,
    deleted_at timestamp,
    updated_at timestamp    not null,
    title      varchar(255) not null,
    miniapp_id varchar(255)
        constraint fk_categories__miniapp
            references miniapps,
    parent_id  bigint
        constraint fk_categories__category
            references categories,
    constraint uk_categories__miniapp_title_parent
        unique (miniapp_id, title, parent_id)
);


create table if not exists geo_entities
(
    id                      uuid         not null
        constraint geo_entities_pkey
            primary key,
    created_at              timestamp    not null,
    is_delete               boolean      not null,
    deleted_at              timestamp,
    updated_at              timestamp    not null,
    building                varchar(50),
    date                    timestamp,
    description             varchar(255),
    house                   varchar(50),
    image_url               varchar(255),
    latitude                double precision,
    longitude               double precision,
    miniapp_entity_class    varchar(255) not null,
    miniapp_entity_id       varchar(255) not null,
    miniapp_group_key       varchar(255),
    needs_reindex           boolean      not null,
    next_open_recalculation timestamp,
    open                    boolean      not null,
    preview_image_url       varchar(255),
    properties              jsonb,
    street                  varchar(200),
    tags                    text[],
    title                   varchar(255) not null,
    works_till              smallint,
    sort_position           integer,
    category_id             bigint
        constraint fk_geo_entity__category
            references categories,
    city_id                 uuid         not null
        constraint fk_geo_entities__city
            references cities,
    miniapp_id              varchar(255) not null
        constraint fk_geo_entities__miniapp
            references miniapps,
    constraint uk_geo_entities__miniapp_miniapp_entity
        unique (miniapp_id, miniapp_entity_id)
);


create table if not exists zones
(
    id                   bigint       not null
        constraint zones_pkey
            primary key,
    geometry_coordinates jsonb        not null,
    geometry_type        varchar(255) not null,
    miniapp_zone_id      varchar(255),
    properties           jsonb,
    sort_position        integer,
    geo_entity_id        uuid         not null
        constraint fk_zone__geo_entities
            references geo_entities,
    constraint uk_zones__miniapp_zone_geo_entity
        unique (geo_entity_id, miniapp_zone_id)
);


create table if not exists opening_hours_rules
(
    id            bigint   not null
        constraint opening_hours_rules_pkey
            primary key,
    date          date,
    day_of_week   int2,

    open_from     smallint not null,
    open_to       smallint not null,
    geo_entity_id uuid     not null
        constraint fk_opening_hours_rules__geo_entity
            references geo_entities,
    constraint uk_opening_hours_rules__date_day_of_week_geo_entity
        unique (day_of_week, date, geo_entity_id),
    constraint uk_opening_hours__day_of_week_geo_entity
        unique (day_of_week, geo_entity_id),
    constraint uk_opening_hours__date_geo_entity
        unique (date, geo_entity_id)
);

CREATE TABLE IF NOT EXISTS dashboard
(
    id           uuid         not null
        constraint dashboard_pkey
            primary key,
    title        varchar(255) not null,
    type         varchar(255) not null,
    miniapp_id   varchar(255)
        constraint fk_dashboard__miniapp
            references miniapps,
    profile_type varchar(255) not null,
    ancor_menu   boolean      not null,
    created_at   timestamp    not null,
    is_delete    boolean      not null,
    deleted_at   timestamp,
    updated_at   timestamp    not null
);

CREATE TABLE IF NOT EXISTS section
(
    id            uuid         not null
        constraint section_pkey
            primary key,
    title         varchar(255) not null,
    section_class varchar(255) not null,
    ancor         varchar,
    miniapp_id    varchar(255)
        constraint fk_section__miniapp
            references miniapps,
    created_at    timestamp    not null,
    is_delete     boolean      not null,
    deleted_at    timestamp,
    updated_at    timestamp    not null
);

CREATE TABLE IF NOT EXISTS dashboard_section
(
    id           uuid not null
        constraint dashboard_section_pkey
            primary key,
    dashboard_id uuid
        constraint fk_dashboard_section_dashboard
            references dashboard,
    section_id   uuid
        constraint fk_dashboard_section_section
            references section
);

CREATE TABLE IF NOT EXISTS content
(
    id            uuid         not null
        constraint content_pkey
            primary key,
    section_id       uuid
        constraint fk_content_section
            references section,
    content_class varchar(255) not null,
    content_type  varchar(255) not null,
    params        jsonb,
    created_at    timestamp    not null,
    is_delete     boolean      not null,
    deleted_at    timestamp,
    updated_at    timestamp    not null
);