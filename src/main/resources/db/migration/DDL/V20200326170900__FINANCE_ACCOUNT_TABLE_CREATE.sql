CREATE TABLE `t_finance_account` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `balance` BIGINT NOT NULL DEFAULT '',
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE `t_finance_transfer_history` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `from_account` BIGINT NOT NULL,
  `to_account` BIGINT NOT NULL,
  `amount` BIGINT NOT NULL DEFAULT '',
  `create_by` BIGINT NOT NULL DEFAULT 0,
  `create_date` BIGINT NOT NULL DEFAULT 0,
  `last_update_by` BIGINT NOT NULL DEFAULT 0,
  `last_update_date` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `idx_from_account` (`from_account` ASC),
  INDEX `idx_to_account` (`to_account` ASC));