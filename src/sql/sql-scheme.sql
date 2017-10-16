-- ----------------------------
-- Table structure for user_info
-- ----------------------------

##########客户信息表##########
##########权限表中的用户表##########
DROP TABLE IF EXISTS customer_info;
create table customer_info(
  id BIGINT AUTO_INCREMENT,
  username varchar(255) null,
  area_id varchar(255) null,
  building_id varchar(255) null,
  password varchar(255) null,
  salt varchar(255) null,
  `lock` bool DEFAULT TRUE,
  CONSTRAINT pk_customer_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_users_username ON customer_info(username);

##########角色表##########
DROP TABLE IF EXISTS sys_roles;
CREATE TABLE sys_roles (
  id BIGINT AUTO_INCREMENT,
  role VARCHAR(255),
  description VARCHAR(255),
  available bool DEFAULT FALSE,
  CONSTRAINT pk_sys_roles PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_roles_role ON sys_roles(role);

##########权限表##########
DROP TABLE IF EXISTS sys_permissions;
CREATE TABLE sys_permissions (
  id BIGINT AUTO_INCREMENT,
  permission VARCHAR(255),
  description VARCHAR(255),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_permissions PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_permissions_permission ON sys_permissions(permission);

##########用户角色表##########
DROP TABLE IF EXISTS sys_users_roles;
CREATE TABLE sys_users_roles (
  user_id BIGINT,
  role_id BIGINT,
  CONSTRAINT pk_sys_users_roles PRIMARY KEY(user_id, role_id)
) CHARSET=utf8 ENGINE=InnoDB;

##########角色权限表##########
DROP TABLE IF EXISTS sys_roles_permissions;
CREATE TABLE sys_roles_permissions (
  role_id BIGINT,
  permission_id BIGINT,
  CONSTRAINT pk_sys_roles_permissions PRIMARY KEY(role_id, permission_id)
) CHARSET=utf8 ENGINE=InnoDB;

#########################################################################
##########园区信息表##########
DROP TABLE IF EXISTS area_info;
create table area_info(
  id BIGINT AUTO_INCREMENT,
  area_id varchar(255) null,
  area_name varchar(255) null,
  city varchar(255) null,
  jigou varchar(255) null,
  area_addr varchar(255) null,
  CONSTRAINT pk_area_info PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;

###########大楼信息表##########
DROP TABLE IF EXISTS building_info;
create table building_info(
  id BIGINT AUTO_INCREMENT,
  building_id varchar(255) null,
  building_name varchar(255) null,
  building_addr varchar(255) null,
  area_id varchar(255) null,
  CONSTRAINT pk_building_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########客户-水电表对应表##########
DROP TABLE IF EXISTS customer_meter_info;
create table customer_meter_info(
  id BIGINT AUTO_INCREMENT,
  customer_id varchar(255) null,
  meter_type int null,
  meter_id varchar(255) null,
  CONSTRAINT pk_customer_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########电表信息表########
DROP TABLE IF EXISTS power_meter_info;
create table power_meter_info(
  id BIGINT AUTO_INCREMENT,
  power_meter_id varchar(255) null,
  power_meter_type_id varchar(255) null,
  power_meter_name varchar(255) null,
  power_meter_addr varchar(255) null,
  area_id varchar(255) null,
  building_id varchar(255) null,
  CONSTRAINT pk_customer_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########电表读数表（最新一次last）########
DROP TABLE IF EXISTS power_meter_laster_read;
create table power_meter_laster_read(
  id BIGINT AUTO_INCREMENT,
  power_meter_id varchar(255) null,
  power_meter_para_id varchar(255) null,
  read_value varchar(255) null,
  read_time datetime null,
  CONSTRAINT pk_power_meter_laster_read PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########电表类型-参数对应表###########
DROP TABLE IF EXISTS power_meter_para_info;
create table power_meter_para_info(
  id BIGINT AUTO_INCREMENT,
  power_meter_type_id varchar(255) null,
  power_meter_para_id varchar(255) null,
  power_meter_para_name varchar(255) null,
  CONSTRAINT pk_power_meter_para_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########电表读数记录表###########
DROP TABLE IF EXISTS power_meter_read_record;
create table power_meter_read_record(
  id BIGINT AUTO_INCREMENT,
  power_meter_id varchar(255) null,
  power_meter_type_id varchar(255) null,
  read_value varchar(255) null,
  read_time datetime null,
  CONSTRAINT pk_power_meter_read_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########水表信息表###########
DROP TABLE IF EXISTS water_meter_info;
create table water_meter_info(
  id BIGINT AUTO_INCREMENT,
  water_meter_id varchar(255) null,
  water_meter_type_id varchar(255) null,
  water_meter_name varchar(255) null,
  area_id varchar(255) null,
  building_id varchar(255) null,
  CONSTRAINT pk_water_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########水表读数表（最新一次last）########
DROP TABLE IF EXISTS water_meter_laster_read;
create table water_meter_laster_read(
  id BIGINT AUTO_INCREMENT,
  water_meter_id varchar(255) null,
  water_meter_para_id varchar(255) null,
  read_value varchar(255) null,
  read_time datetime null,
  CONSTRAINT pk_water_meter_laster_read PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########水表类型-参数对应##########
DROP TABLE IF EXISTS water_meter_para_info;
create table water_meter_para_info(
  id BIGINT AUTO_INCREMENT,
  water_meter_type_id varchar(255) null,
  water_meter_para_id varchar(255) null,
  water_meter_para_name varchar(255) null,
  CONSTRAINT pk_water_meter_para_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########水表读数记录表###########
DROP TABLE IF EXISTS water_meter_read_record;
create table water_meter_read_record(
  id BIGINT AUTO_INCREMENT,
  water_meter_id varchar(255) null,
  water_meter_para_id varchar(255) null,
  read_value varchar(255) null,
  read_time datetime null,
  CONSTRAINT pk_water_meter_read_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

