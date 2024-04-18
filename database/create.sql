create database bevi;

grant all privileges 
on bevi.*
to bevi@localhost
identified by 'titok';

use bevi;

create table customers(
    id int not null primary key auto_increment,
    name varchar(50),
    email varchar(50)
);

create table incomings(
    id int not null primary key auto_increment,
    total double,
    date date,
    source varchar(50),
    customerId int
);