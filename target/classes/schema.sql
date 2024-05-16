drop table if exists hole;

create table hole
(
    id    serial not null primary key,
    name   varchar(40) not null check (name <> ''),
    date timestamp not  null,
    latitude varchar(40) not null check (latitude <> ''),
    longitude varchar(40) not null check (longitude <> ''),
    obs varchar(200) check (obs <> ''),
    fixed bool default false,
    foto_id varchar(90) not null check (foto_id <> '')
);