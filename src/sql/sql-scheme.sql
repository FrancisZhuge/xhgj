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


#################电表记录##################
DROP TABLE IF EXISTS power_info;
CREATE TABLE power_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置自增主键',
  number VARCHAR(255) DEFAULT NULL COMMENT '电表编号',
  area_id BIGINT DEFAULT NULL COMMENT '园区表id',
  building_id BIGINT DEFAULT NULL COMMENT '大楼id',
  company_id BIGINT DEFAULT NULL COMMENT '公司id',
  collector_id BIGINT DEFAULT NULL COMMENT '采集器id',
  province_id BIGINT DEFAULT NULL COMMENT '省份的id',
  city_id BIGINT DEFAULT NULL COMMENT '城市的id',
  region_id BIGINT DEFAULT NULL COMMENT '地区的id',
  address VARCHAR(255) DEFAULT NULL COMMENT '地址',
  owner VARCHAR(255) DEFAULT NULL COMMENT '所有者',
  consumption VARCHAR(255) DEFAULT NULL COMMENT '用电名称',
  outgoing VARCHAR(255) DEFAULT NULL COMMENT '出线号',
  comment1 VARCHAR(255) DEFAULT NULL COMMENT '备注1',
  comment2 VARCHAR(255) DEFAULT NULL COMMENT '备注2',
  comment3 VARCHAR(255) DEFAULT NULL COMMENT '备注3',
  CONSTRAINT pk_power_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

DROP TABLE IF EXISTS power_meter_record;
CREATE TABLE power_meter_record(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  power_info_id BIGINT DEFAULT NULL COMMENT 'power_info的主键字段',
  code INT DEFAULT NULL COMMENT '编程设置密码',
  uan FLOAT DEFAULT NULL COMMENT 'A相电压',
  ubn FLOAT DEFAULT NULL COMMENT 'B项电压',
  ucn FLOAT DEFAULT NULL COMMENT 'C项电压',
  uab FLOAT DEFAULT NULL COMMENT '线电压uab',
  ubc FLOAT DEFAULT NULL COMMENT '线电压ubc',
  uca FLOAT DEFAULT NULL COMMENT '线电压uca',
  ia FLOAT DEFAULT NULL COMMENT 'A项电流',
  ib FLOAT DEFAULT NULL COMMENT 'B项电流',
  ic FLOAT DEFAULT NULL COMMENT 'C项电流',
  pa FLOAT DEFAULT NULL COMMENT 'A相有功功率',
  pb FLOAT DEFAULT NULL COMMENT 'B相有功功率',
  pc FLOAT DEFAULT NULL COMMENT 'C相有功功率',
  ps FLOAT DEFAULT NULL COMMENT '合相有功功率',
  qa FLOAT DEFAULT NULL COMMENT 'A相无功功率',
  qb FLOAT DEFAULT NULL COMMENT 'B相无功功率',
  qc FLOAT DEFAULT NULL COMMENT 'C相无功功率',
  qs FLOAT DEFAULT NULL COMMENT '合相无功功率',
  sa FLOAT DEFAULT NULL COMMENT 'A相视在功率',
  sb FLOAT DEFAULT NULL COMMENT 'B相视在功率',
  sc FLOAT DEFAULT NULL COMMENT 'C相视在功率',
  ss FLOAT DEFAULT NULL COMMENT '合相视在功率',
  pfa FLOAT DEFAULT NULL COMMENT 'A相功率因素',
  pfb FLOAT DEFAULT NULL COMMENT 'B相功率因素',
  pfc FLOAT DEFAULT NULL COMMENT 'C相功率因素',
  pfs FLOAT DEFAULT NULL COMMENT '合相功率因素',
  fr FLOAT DEFAULT NULL COMMENT '电网频率',
  by_kwhz FLOAT DEFAULT NULL COMMENT '本月总正向有功电能',
  by_kwhj FLOAT DEFAULT NULL COMMENT '本月尖正向有功电能',
  by_kwhf FLOAT DEFAULT NULL COMMENT '本月峰正向有功电能',
  by_kwhp FLOAT DEFAULT NULL COMMENT '本月正向有功电能',
  by_kwhg FLOAT DEFAULT NULL COMMENT '本月谷正向有功电能',
  by_hkwhz FLOAT DEFAULT NULL COMMENT '本月总反向有功电能',
  by_hkwhj FLOAT DEFAULT NULL COMMENT '本月尖反向有功电能',
  by_hkwhf FLOAT DEFAULT NULL COMMENT '本月峰反向有功电能',
  by_hkwhp FLOAT DEFAULT NULL COMMENT '本月平反向有功电能',
  by_hkwhg FLOAT DEFAULT NULL COMMENT '本月谷反向有功电能',
  by_kvarhz FLOAT DEFAULT NULL COMMENT '本月总正向无功电能',
  by_kvarhj FLOAT DEFAULT NULL COMMENT '本月尖正向无功电能',
  by_kvarhf FLOAT DEFAULT NULL COMMENT '本月峰正向无功电能',
  by_kvarhp FLOAT DEFAULT NULL COMMENT '本月平正向无功电能',
  by_kvarhg FLOAT DEFAULT NULL COMMENT '本月谷正向无功电能',
  by_hkvarhz FLOAT DEFAULT NULL COMMENT '本月总反向无功电能',
  by_hkvarhj FLOAT DEFAULT NULL COMMENT '本月尖反向无功电能',
  by_hkvarhhf FLOAT DEFAULT NULL COMMENT '本月峰反向无功电能',
  by_hkvarhp FLOAT DEFAULT NULL COMMENT '本月平反向无功电能',
  by_hkvarhg FLOAT DEFAULT NULL COMMENT '本月谷反无功电能',
  sy_kwhz FLOAT DEFAULT NULL COMMENT '上月总正向有功电能',
  sy_kwhj FLOAT DEFAULT NULL COMMENT '上月尖正向有功电能',
  sy_kwhf FLOAT DEFAULT NULL COMMENT '上月峰正向有功电能',
  sy_kwhp FLOAT DEFAULT NULL COMMENT '上月正向有功电能',
  sy_kwhg FLOAT DEFAULT NULL COMMENT '上月谷正向有功电能',
  sy_hkwhz FLOAT DEFAULT NULL COMMENT '上月总反向有功电能',
  sy_hkwhj FLOAT DEFAULT NULL COMMENT '上月尖反向有功电能',
  sy_hkwhf FLOAT DEFAULT NULL COMMENT '上月峰反向有功电能',
  sy_hkwhp FLOAT DEFAULT NULL COMMENT '上月平反向有功电能',
  sy_hkwhg FLOAT DEFAULT NULL COMMENT '上月谷反向有功电能',
  sy_kvarhz FLOAT DEFAULT NULL COMMENT '上月总正向无功电能',
  sy_kvarhj FLOAT DEFAULT NULL COMMENT '上月尖正向无功电能',
  sy_kvarhf FLOAT DEFAULT NULL COMMENT '上月峰正向无功电能',
  sy_kvarhp FLOAT DEFAULT NULL COMMENT '上月平正向无功电能',
  sy_kvarhg FLOAT DEFAULT NULL COMMENT '上月谷正向无功电能',
  sy_hkvarhz FLOAT DEFAULT NULL COMMENT '上月总反向无功电能',
  sy_hkvarhj FLOAT DEFAULT NULL COMMENT '上月尖反向无功电能',
  sy_hkvarhhf FLOAT DEFAULT NULL COMMENT '上月峰反向无功电能',
  sy_hkvarhp FLOAT DEFAULT NULL COMMENT '上月平反向无功电能',
  sy_hkvarhg FLOAT DEFAULT NULL COMMENT '上月谷反无功电能',
  ssy_kwhz FLOAT DEFAULT NULL COMMENT '上上月总正向有功电能',
  ssy_kwhj FLOAT DEFAULT NULL COMMENT '上上月尖正向有功电能',
  ssy_kwhf FLOAT DEFAULT NULL COMMENT '上上月峰正向有功电能',
  ssy_kwhp FLOAT DEFAULT NULL COMMENT '上上月正向有功电能',
  ssy_kwhg FLOAT DEFAULT NULL COMMENT '上上月谷正向有功电能',
  ssy_hkwhz FLOAT DEFAULT NULL COMMENT '上上月总反向有功电能',
  ssy_hkwhj FLOAT DEFAULT NULL COMMENT '上上月尖反向有功电能',
  ssy_hkwhf FLOAT DEFAULT NULL COMMENT '上上月峰反向有功电能',
  ssy_hkwhp FLOAT DEFAULT NULL COMMENT '上上月平反向有功电能',
  ssy_hkwhg FLOAT DEFAULT NULL COMMENT '上上月谷反向有功电能',
  ssy_kvarhz FLOAT DEFAULT NULL COMMENT '上上月总正向无功电能',
  ssy_kvarhj FLOAT DEFAULT NULL COMMENT '上上月尖正向无功电能',
  ssy_kvarhf FLOAT DEFAULT NULL COMMENT '上上月峰正向无功电能',
  ssy_kvarhp FLOAT DEFAULT NULL COMMENT '上上月平正向无功电能',
  ssy_kvarhg FLOAT DEFAULT NULL COMMENT '上上月谷正向无功电能',
  ssy_hkvarhz FLOAT DEFAULT NULL COMMENT '上上月总反向无功电能',
  ssy_hkvarhj FLOAT DEFAULT NULL COMMENT '上上月尖反向无功电能',
  ssy_hkvarhhf FLOAT DEFAULT NULL COMMENT '上上月峰反向无功电能',
  ssy_hkvarhp FLOAT DEFAULT NULL COMMENT '上上月平反向无功电能',
  ssy_hkvarhg FLOAT DEFAULT NULL COMMENT '上上月谷反无功电能',
  read_time DATETIME DEFAULT current_timestamp COMMENT '创建时间',
  CONSTRAINT pk_power_meter_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

--
--    表结构   province
--
DROP TABLE IF EXISTS province;
CREATE TABLE IF NOT EXISTS province (
  id BIGINT NOT NULL auto_increment,
  province_id int(11) NOT NULL,
  province varchar(20) NOT NULL,
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;

--
--    表的结构   city
--

DROP TABLE IF EXISTS city;
CREATE TABLE IF NOT EXISTS city (
  id BIGINT NOT NULL auto_increment,
  city_id int(11) NOT NULL,
  city varchar(20) NOT NULL,
  father_id int(11) NOT NULL,
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;

--
-- 表的结构    area
--

DROP TABLE IF EXISTS area;
CREATE TABLE IF NOT EXISTS area(
  id BIGINT NOT NULL auto_increment,
  area_id int(11) NOT NULL,
  area varchar(20) character set gbk NOT NULL,
  father_id int(11) NOT NULL,
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;