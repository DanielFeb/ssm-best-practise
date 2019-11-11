CREATE TABLE `t_application` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT '',
  `description` VARCHAR(200) NOT NULL DEFAULT '',
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `idx_application_name` (`name` ASC));

CREATE TABLE `t_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `application_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(45) NOT NULL DEFAULT '',
  `description` VARCHAR(200) NOT NULL DEFAULT '',
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `idx_role_application_id` (`application_id` ASC),
  INDEX `idx_role_name` (`name` ASC));

CREATE TABLE `t_resource` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `application_id` BIGINT NOT NULL DEFAULT 0,
  `uri` VARCHAR(45) NOT NULL DEFAULT '',
  `description` VARCHAR(200) NOT NULL DEFAULT '',
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `idx_resource_uri` (`uri` ASC),
  INDEX `idx_resource_application_id` (`application_id` ASC));

CREATE TABLE `t_role_resource_relation` (
  `role_id` BIGINT NOT NULL DEFAULT 0,
  `resource_id` BIGINT NOT NULL DEFAULT 0,
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`role_id`, `resource_id`),
  INDEX `idx_rrr_resource_id` (`resource_id` ASC));

CREATE TABLE `t_user_role_relation` (
  `user_id` BIGINT NOT NULL DEFAULT 0,
  `role_id` BIGINT NOT NULL DEFAULT 0,
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `idx_urr_role_id` (`role_id` ASC));

