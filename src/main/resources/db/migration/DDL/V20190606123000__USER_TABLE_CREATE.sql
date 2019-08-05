CREATE TABLE `archessm`.`t_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `create_by` INT NOT NULL,
  `create_date` datetime NOT NULL,
  `last_update_by` INT NOT NULL,
  `last_update_date` datetime NOT NULL,
  PRIMARY KEY (`id`));
