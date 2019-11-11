-- create super user
INSERT INTO `t_user`
  (
    `username`,
    `password`,
    `phone_number`,
    `email`,
    `identity_number`,
    `nickname`,
    `address`,
    `birth_date`,
    `sex`,
    `create_by`,
    `create_date`,
    `last_update_by`,
    `last_update_date`)
VALUES
  (
    'admin',
    'admin',
    '', '', '',
    'admin',
    'Im on Mars',
    '0', '2', '1', '0', '1', '0'
  );

-- create auth application
INSERT INTO `t_application`
  (`id`, `name`, `description`, `create_by`, `last_update_by`)
VALUES
  ('1', 'AUTH', 'AUTH', '1', '1');

-- create auth application roles
INSERT INTO `t_role`
  (`id`, `application_id`, `name`,
   `description`, `create_by`, `last_update_by`)
 VALUES
  ('1', '1', 'ADMIN',
  'super user', '1', '1');
INSERT INTO `t_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('2', '1', 'NONE',
  'no auth', '1', '1');

-- add admin role for super user
INSERT INTO `t_user_role_relation`
  (`user_id`, `role_id`, `create_by`)
VALUES
  ('1', '1', '1');


