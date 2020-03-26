-- create restaurant application
INSERT INTO `t_auth_application`
  (`id`, `name`, `description`, `create_by`, `last_update_by`)
VALUES
  ('2', 'RESTAURANT', 'RESTAURANT', '1', '1');

-- create roles for restaurant application
INSERT INTO `t_auth_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('3', '2', 'ADMIN',
  'system manager', '1', '1');
INSERT INTO `t_auth_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('4', '2', 'OWNER',
  'restaurant owner', '1', '1');
INSERT INTO `t_auth_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('5', '2', 'ACCOUNTANT',
  'checker', '1', '1');
INSERT INTO `t_auth_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('6', '2', 'CHIEF',
  'cooker', '1', '1');
INSERT INTO `t_auth_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('7', '2', 'WAITER',
  'waiter or waitress', '1', '1');
INSERT INTO `t_auth_role`
  (`id`, `application_id`, `name`,
  `description`, `create_by`, `last_update_by`)
VALUES
  ('8', '2', 'CONSUMER',
  'consumer', '1', '1');


