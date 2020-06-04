create table department
(
	id int(11) not null auto_increment,
	name varchar(255) not null,
	reg_dt datetime not null default CURRENT_TIMESTAMP,
	reg_nm varchar(50) not null,
	modi_dt datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
	modi_nm varchar(50) not null,
	constraint department_pk primary key (id)
);

create table symptom
(
    id int(11) not null auto_increment,
    name varchar(255) not null,
    reg_dt datetime not null default CURRENT_TIMESTAMP,
	reg_nm varchar(50) not null,
	modi_dt datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
	modi_nm varchar(50) not null,
	constraint symptom_pk primary key (id)
);

create table department_symptom_mapping
(
    department_id int(11) not null,
    symptom_id int(11) not null,
    reg_dt datetime not null default CURRENT_TIMESTAMP,
    reg_nm varchar(50) not null,
    modi_dt datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    modi_nm varchar(50) not null,
    constraint department_symptom_mapping_pk primary key (department_id, symptom_id)
);

create table doctor(
    id int(11) not null auto_increment,
    name varchar(255) not null,
    department_id int(11) not null,
    image_url varchar(255) null,
    address varchar(255) not null,
    ward varchar(255) not null,
    district varchar(50) not null,
    province varchar(50) not null,
    reg_dt datetime not null default CURRENT_TIMESTAMP,
    reg_nm varchar(50) not null,
    modi_dt datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    modi_nm varchar(50) not null,
    constraint department_symptom_mapping_pk primary key (id)
);