-- ----------------------------
-- Table structure for user_info
-- ----------------------------
##########用户表##########
DROP TABLE IF EXISTS sys_users;
CREATE TABLE sys_users (
  id BIGINT AUTO_INCREMENT,
  username VARCHAR (255),
  password VARCHAR(255),
  salt VARCHAR(255),
  locked BOOL DEFAULT FALSE ,
  CONSTRAINT pk_sys_users PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_users_username ON sys_users(username);

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