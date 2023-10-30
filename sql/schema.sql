create schema permission_center collate utf8mb4_general_ci;

CREATE TABLE `system` (
  id          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  creator_id  bigint(20)          NOT NULL COMMENT '创建人ID',
  modifier_id bigint(20)          NOT NULL COMMENT '修改人ID',
  create_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  version     int(10)             NOT NULL DEFAULT 1 COMMENT '版本号',
  code        varchar(100)        NOT NULL COMMENT '唯一系统编码',
  name        varchar(100)        NOT NULL COMMENT '系统名字',
  description varchar(255)                 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (id),
  UNIQUE KEY uq_code (code),
  INDEX idx_name (name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='业务系统表';

CREATE TABLE resource (
  id          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  creator_id  bigint(20)          NOT NULL COMMENT '创建人ID',
  modifier_id bigint(20)          NOT NULL COMMENT '修改人ID',
  create_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  version     int(10)             NOT NULL DEFAULT 1 COMMENT '版本号',
  code        varchar(100)        NOT NULL COMMENT '资源唯一编码',
  name        varchar(100)        NOT NULL COMMENT '资源名字',
  description varchar(255)                 DEFAULT NULL COMMENT '描述',
  type        smallint(6)         NOT NULL COMMENT '资源类型：1-菜单 2-按钮',
  system_code varchar(100)        NOT NULL COMMENT '系统编码',
  url         varchar(255)                 DEFAULT NULL COMMENT 'URL',
  level       int(10)             NOT NULL COMMENT '资源层级',
  parent_id   bigint(20)          NOT NULL COMMENT '父资源ID',
  PRIMARY KEY (id),
  UNIQUE KEY uq_code (code),
  INDEX idx_name (name),
  INDEX idx_system_code (system_code),
  INDEX idx_parent_id (parent_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='资源表';

CREATE TABLE role (
  id          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  creator_id  bigint(20)          NOT NULL COMMENT '创建人ID',
  modifier_id bigint(20)          NOT NULL COMMENT '修改人ID',
  create_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  version     int(10)             NOT NULL DEFAULT 1 COMMENT '版本号',
  code        varchar(100)        NOT NULL COMMENT '角色唯一编码',
  name        varchar(100)        NOT NULL COMMENT '角色名称',
  description varchar(255)                 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (id),
  UNIQUE KEY uq_code (code)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='角色表';

CREATE TABLE role_resource (
  id            bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  creator_id    bigint(20)          NOT NULL COMMENT '创建人ID',
  modifier_id   bigint(20)          NOT NULL COMMENT '修改人ID',
  create_time   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  role_code     varchar(100)        NOT NULL COMMENT '角色编码',
  resource_code varchar(100)        NOT NULL COMMENT '资源编码',
  PRIMARY KEY (id), 
  INDEX idx_role_code (role_code),
  INDEX idx_resource_code (resource_code)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='角色资源关系表';

CREATE TABLE user (
  id          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  creator_id  bigint(20)          NOT NULL COMMENT '创建人ID',
  modifier_id bigint(20)          NOT NULL COMMENT '修改人ID',
  create_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  version     int(10)             NOT NULL DEFAULT 1 COMMENT '版本号',
  user_id     bigint(20)          NOT NULL COMMENT '用户ID',
  email       varchar(100)        NOT NULL COMMENT '邮箱',
  name        varchar(100)        NOT NULL COMMENT '用户名字',
  password    varchar(500)        NOT NULL COMMENT '密码',
  status      smallint(6)         NOT NULL DEFAULT 0 COMMENT '状态：0-禁用 1-启用',
  PRIMARY KEY (id),
  UNIQUE KEY uq_user_id (user_id),
  INDEX idx_email (email)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='用户表';

CREATE TABLE user_role (
  id          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  creator_id  bigint(20)          NOT NULL COMMENT '创建人ID',
  modifier_id bigint(20)          NOT NULL COMMENT '修改人ID',
  create_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  user_id     bigint(20)          NOT NULL COMMENT '用户ID',
  role_code   varchar(100)        NOT NULL COMMENT '角色编码',
  PRIMARY KEY (id), 
  INDEX idx_user_id (user_id),
  INDEX idx_role_code (role_code)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='用户角色关系表';
