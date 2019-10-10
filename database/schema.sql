create table booking
(
    id            bigint auto_increment primary key,
    can_comment   bit          not null,
    date_time     datetime     null,
    note          varchar(255) null,
    status        varchar(16)  null,
    status_reason varchar(255) null,
    doctor_id     bigint       null,
    patient_id    bigint       null,
    created_date  datetime     null,
    updated_date  datetime     null
)
    charset = utf8;


create table comment
(
    book_id      bigint       not null primary key,
    content      varchar(255) null,
    doctor_id    bigint       null,
    rate         float        not null,
    created_date datetime     null,
    updated_date datetime     null
)
    charset = utf8;

create table day_off
(
    id         bigint auto_increment primary key,
    date_time  datetime null,
    end_hour   int      null,
    start_hour int      null,
    user_id    bigint   null
)
    charset = utf8;


create table department
(
    id   bigint auto_increment primary key,
    name varchar(255) null
)
    charset = utf8;

create table health_record
(
    book_id            bigint                    not null primary key,
    content            varchar(255) charset utf8 null,
    prescription_image varchar(255) charset utf8 null,
    user_id            bigint                    null
);


create table department_relate_symptom
(
    symptom_id    bigint not null,
    department_id bigint not null
)
    charset = utf8;

create table firebase_token
(
    id      bigint auto_increment primary key,
    token   varchar(255) null,
    user_id bigint       not null
)
    charset = utf8;

create table notification_inbox
(
    id                bigint auto_increment primary key,
    click_action      varchar(255) null,
    icon              varchar(255) null,
    is_read           bit          null,
    notification_body varchar(255) null,
    title             varchar(255) null,
    user_id           bigint       null
)
    charset = utf8;

create table profile
(
    user_id          bigint         not null primary key,
    profile_type     varchar(31)    not null,
    avatar_img       varchar(255)   null,
    date_of_birth    datetime       null,
    description      varchar(255)   null,
    gender           int            null,
    name             varchar(255)   null,
    person_id_number varchar(255)   null,
    phone_number     varchar(255)   null,
    address          varchar(255)   null,
    address_title    varchar(255)   null,
    balance          decimal(19, 2) null,
    base_price       decimal(19, 2) null,
    rate_summary     float          null,
    title            varchar(255)   null,
    work_office      varchar(255)   null,
    height           float          null,
    weight           float          null,
    department_id    bigint         null
)
    charset = utf8;

create table role
(
    id   bigint auto_increment primary key,
    name varchar(255) null
)
    charset = utf8;

create table schedule
(
    id          bigint auto_increment primary key,
    day_of_week int    null,
    end_hour    int    null,
    start_hour  int    null,
    user_id     bigint null
)
    charset = utf8;


create table sns_user
(
    sns_type   varchar(31)  not null,
    sns_id     varchar(255) not null,
    birth_day  varchar(255) null,
    email      varchar(255) null,
    gender     varchar(255) null,
    raw_data   varchar(255) null,
    user_name  varchar(255) null,
    photo_url  varchar(255) null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    user_id    bigint       not null,
    primary key (sns_id, user_id)
)
    charset = utf8;

create table symptom
(
    id          bigint auto_increment primary key,
    description varchar(255) null,
    name        varchar(255) null
)
    charset = utf8;

create table user
(
    id           bigint auto_increment primary key,
    email        varchar(255) null,
    password     varchar(255) null,
    status       varchar(8)   null,
    created_date datetime     null,
    updated_date datetime     null
)
    charset = utf8;

create table users_roles
(
    user_id bigint not null,
    role_id bigint not null
)
    charset = utf8;
