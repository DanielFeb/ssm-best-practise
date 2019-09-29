CREATE TABLE `t_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `birth_date` BIGINT NOT NULL,
  `sex` TINYINT NOT NULL,
  `create_by` BIGINT NOT NULL,
  `create_date` BIGINT NOT NULL,
  `last_update_by` BIGINT NOT NULL,
  `last_update_date` BIGINT NOT NULL,
  PRIMARY KEY (`id`));
