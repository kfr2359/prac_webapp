create database if not exists prac_db default character set utf8;

use prac_db;

create table if not exists `client` (
	`id` int unsigned not null auto_increment,
    `name` varchar(256) not null,
    primary key (`id`)
);

create table if not exists `job` (
	`id` int unsigned not null auto_increment,
    `name` varchar(256) not null,
    primary key (`id`)
);

create table if not exists `service_type` (
	`id` int unsigned not null auto_increment,
    `name` varchar(256) not null,
    primary key (`id`)
);

------
create table if not exists `employee` (
	`id` int unsigned not null auto_increment,
    `name` varchar(256) not null,
    `address` varchar(256) not null,
    `education` varchar(256) not null,
    `jobId` int unsigned not null,
    primary key (`id`),
    foreign key (`jobId`) references `job`(`id`) on delete cascade
);


create table if not exists `service` (
	`id` int unsigned not null auto_increment,
    `typeId` int unsigned not null,
    `clientId` int unsigned not null,
    `cost` float(10,2) unsigned,
    `startDate` date,
    `endDate` date,
    primary key (`id`),
    foreign key (`typeId`) references `service_type`(`id`) on delete cascade,
    foreign key (`clientId`) references `client`(`id`) on delete cascade
);

create table if not exists `client_contact` (
	`id` int unsigned not null auto_increment,
    `name` varchar(256) not null,
    `address` varchar(256) not null,
    `clientId` int unsigned not null,
    primary key (`id`),
    foreign key (`clientId`) references `client`(`id`) on delete cascade
);

create table if not exists `client_contact_phone` (
	`id` int unsigned not null auto_increment,
    `contactId` int unsigned not null,
    `phone` varchar(256) not null,
    primary key (`id`),
    foreign key (`contactId`) references `client_contact`(`id`) on delete cascade
);

create table if not exists `client_contact_email` (
	`id` int unsigned not null auto_increment,
    `contactId` int unsigned not null,
    `email` varchar(256) not null,
    primary key (`id`),
    foreign key (`contactId`) references `client_contact`(`id`) on delete cascade
);

--
create table if not exists `employee_phone` (
	`id` int unsigned not null auto_increment,
    `employeeId` int unsigned not null,
    `phone` varchar(256) not null,
    primary key (`id`),
    foreign key (`employeeId`) references `employee`(`id`) on delete cascade
);

create table if not exists `employee_email` (
	`id` int unsigned not null auto_increment,
    `employeeId` int unsigned not null,
    `email` varchar(256) not null,
    primary key (`id`),
    foreign key (`employeeId`) references `employee`(`id`) on delete cascade
);

create table if not exists `service_employee` (
	`serviceId` int unsigned not null,
    `employeeId` int unsigned not null,
    primary key (`serviceId`, `employeeId`),
    foreign key (`serviceId`) references `service`(`id`) on delete cascade,
    foreign key (`employeeId`) references `employee`(`id`) on delete cascade
);
