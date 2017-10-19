-- ----------------------------
-- Table structure for user_info
-- ----------------------------

##########客户信息表##########
##########权限表中的用户表##########
DROP TABLE IF EXISTS user_info;
create table user_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  user_no VARCHAR(255) COMMENT '用户编号',
  username varchar(255) COMMENT '用户名',
  area_id BIGINT COMMENT '园区信息表主键',
  building_id BIGINT COMMENT '大楼信息表主键',
  password varchar(255) null COMMENT '密码',
  salt varchar(255) null COMMENT '盐',
  locked bool DEFAULT TRUE COMMENT '是否锁定 0-false-不锁定  1-true-已锁定',
  CONSTRAINT pk_customer_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_users_username ON user_info(username);

##########角色表##########
DROP TABLE IF EXISTS sys_roles;
CREATE TABLE sys_roles (
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  role VARCHAR(255) COMMENT '权限',
  description VARCHAR(255) COMMENT '描述',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  CONSTRAINT pk_sys_roles PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_roles_role ON sys_roles(role);

##########权限表##########
DROP TABLE IF EXISTS sys_permissions;
CREATE TABLE sys_permissions (
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  permission VARCHAR(255) COMMENT '权限',
  description VARCHAR(255) COMMENT '描述',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  CONSTRAINT pk_sys_permissions PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_permissions_permission ON sys_permissions(permission);

##########用户角色表##########
DROP TABLE IF EXISTS sys_users_roles;
CREATE TABLE sys_users_roles (
  user_id BIGINT COMMENT 'user_info的id',
  role_id BIGINT COMMENT 'sys_roles的id',
  CONSTRAINT pk_sys_users_roles PRIMARY KEY(user_id, role_id)
) CHARSET=utf8 ENGINE=InnoDB;

##########角色权限表##########
DROP TABLE IF EXISTS sys_roles_permissions;
CREATE TABLE sys_roles_permissions (
  role_id BIGINT COMMENT 'sys_roles的id',
  permission_id BIGINT COMMENT 'sys_permissions的id',
  CONSTRAINT pk_sys_roles_permissions PRIMARY KEY(role_id, permission_id)
) CHARSET=utf8 ENGINE=InnoDB;

#########################################################################
##########园区信息表##########
DROP TABLE IF EXISTS area_info;
create table area_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  area_no VARCHAR(255) NULL COMMENT '园区编号',
  area_name varchar(255) null COMMENT '园区名称（西湖国际，湖州）',
  city varchar(255) null COMMENT '所在城市',
  jigou varchar(255) null COMMENT '所属机构（中节能）',
  area_addr varchar(255) null COMMENT '地址',
  CONSTRAINT pk_area_info PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;

###########大楼信息表##########
DROP TABLE IF EXISTS building_info;
create table building_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  building_no VARCHAR(255) NULL  COMMENT '大楼编号',
  building_name varchar(255) null COMMENT '大楼名称',
  building_addr varchar(255) null COMMENT '地址',
  area_id BIGINT COMMENT '所在园区id',
  CONSTRAINT pk_building_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########客户-水电表对应表##########
DROP TABLE IF EXISTS user_meter_info;
create table user_meter_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  user_id BIGINT COMMENT '用户id,对应用户信息表id',
  meter_type int null COMMENT '(0,水表，1电表）',
  meter_id varchar(255) null COMMENT '电表或水表号',
  CONSTRAINT pk_customer_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########电表信息表########
DROP TABLE IF EXISTS power_meter_info;
create table power_meter_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增' ,
  power_meter_no VARCHAR(255) NULL COMMENT '电表编号',
  power_meter_type varchar(255) null COMMENT '电表类型',
  power_meter_name varchar(255) null COMMENT '电表名称',
  power_meter_addr varchar(255) null COMMENT '电表地址',
  area_id BIGINT COMMENT '所在园区id,对应到area表主键',
  building_id BIGINT COMMENT '所在大楼id，对应到building表主键',
  CONSTRAINT pk_customer_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;


##########电表类型-参数对应表###########
DROP TABLE IF EXISTS power_meter_para_info;
create table power_meter_para_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  power_meter_para_id BIGINT COMMENT '电表参数id',
  power_meter_type varchar(255) null COMMENT '电表类型，对应电表信息表',
  power_meter_para_name varchar(255) null COMMENT '参数名称',
  CONSTRAINT pk_power_meter_para_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########电表读数记录表###########
DROP TABLE IF EXISTS power_meter_read_record;
create table power_meter_read_record(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  power_meter_id BIGINT COMMENT '电表id，对应power_meter_info id',
  power_meter_para_id BIGINT COMMENT '参数类型id',
  read_value varchar(255) null COMMENT '读数value',
  read_time datetime null COMMENT '读数时间',
  CONSTRAINT pk_power_meter_read_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########水表信息表###########
DROP TABLE IF EXISTS water_meter_info;
create table water_meter_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  water_meter_no BIGINT COMMENT '水表编号',
  water_meter_type varchar(255) COMMENT '水表类型',
  water_meter_name varchar(255) null COMMENT '水表名称',
  area_id BIGINT COMMENT '所在园区',
  building_id BIGINT COMMENT '所在大楼',
  CONSTRAINT pk_water_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;


##########水表类型-参数对应##########
DROP TABLE IF EXISTS water_meter_para_info;
create table water_meter_para_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  water_meter_para_id BIGINT COMMENT '参数id',
  water_meter_type varchar(255) null COMMENT '水表类型',
  water_meter_para_name varchar(255) null COMMENT '参数名称',
  CONSTRAINT pk_water_meter_para_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

##########水表读数记录表###########
DROP TABLE IF EXISTS water_meter_read_record;
create table water_meter_read_record(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  water_meter_id BIGINT COMMENT '对应water id',
  water_meter_para_id BIGINT COMMENT '参数类型id',
  read_value varchar(255) null COMMENT '读数value',
  read_time datetime null COMMENT '读数时间',
  CONSTRAINT pk_water_meter_read_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

