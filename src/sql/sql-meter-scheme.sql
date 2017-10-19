create table area_info
(
	id int auto_increment
		primary key,
	area_id varchar(255) null,
	area_name varchar(255) null,
	city varchar(255) null,
	jigou varchar(255) null,
	area_addr varchar(255) null
)
;

create table building_info
(
	id int auto_increment
		primary key,
	building_id varchar(255) null,
	building_name varchar(255) null,
	building_addr varchar(255) null,
	area_id varchar(255) null
)
;

create table customer_info
(
	id int null,
	customer_id varchar(255) null,
	customer_name varchar(255) null,
	area_id varchar(255) null,
	building_id varchar(255) null,
	password varchar(255) null,
	salt varchar(255) null,
	`lock` tinyint(1) null
)
;

create table customer_meter_info
(
	id int null,
	customer_id varchar(255) null,
	meter_type int null,
	meter_id varchar(255) null
)
;

create table power_meter_info
(
	id int auto_increment
		primary key,
	power_meter_id varchar(255) null,
	power_meter_type_id varchar(255) null,
	power_meter_name varchar(255) null,
	power_meter_addr varchar(255) null,
	area_id varchar(255) null,
	building_id varchar(255) null
)
;

create table power_meter_laster_read
(
	id int null,
	power_meter_id varchar(255) null,
	power_meter_para_id varchar(255) null,
	read_value varchar(255) null,
	read_time datetime null
)
;

create table power_meter_para_info
(
	id int auto_increment
		primary key,
	power_meter_type_id varchar(255) null,
	power_meter_para_id varchar(255) null,
	power_meter_para_name varchar(255) null
)
;

create table power_meter_read_record
(
	id int null,
	power_meter_id varchar(255) null,
	power_meter_type_id varchar(255) null,
	read_value varchar(255) null,
	read_time datetime null
)
;

create table water_meter_info
(
	id int null,
	water_meter_id varchar(255) null,
	water_meter_type_id varchar(255) null,
	water_meter_name varchar(255) null,
	area_id varchar(255) null,
	building_id varchar(255) null
)
;

create table water_meter_laster_read
(
	id int null,
	water_meter_id varchar(255) null,
	water_meter_para_id varchar(255) null,
	read_value varchar(255) null,
	read_time datetime null
)
;

create table water_meter_para_info
(
	id int null,
	water_meter_type_id varchar(255) null,
	water_meter_para_id varchar(255) null,
	water_meter_para_name varchar(255) null
)
;

create table water_meter_read_record
(
	id int null,
	water_meter_id varchar(255) null,
	water_meter_para_id varchar(255) null,
	read_value varchar(255) null,
	read_time datetime null
)
;

