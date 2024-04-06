use `managementhotel`;

INSERT IGNORE INTO role (role_id, role_name, role_is_active) VAlUE (1, 'admin', true);
INSERT IGNORE INTO role (role_id, role_name, role_is_active) VAlUE (2, 'user', true);
INSERT IGNORE INTO role (role_id, role_name, role_is_active) VAlUE (3, 'guest', true);

INSERT IGNORE INTO user (user_id, user_name, user_password, user_is_active, role_id) value (1, 'giangnam.17122002@gmail.com', '12345678', true, 1);
INSERT IGNORE INTO user (user_id, user_name, user_password, user_is_active, role_id) value (2, 'huutrong1101@gmail.com', '12345678', true, 2);


