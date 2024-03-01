-- system
INSERT INTO `system` (id, creator_id, modifier_id, create_time, update_time, version, code, name, description) VALUES (1, 1, 1, now(), now(), 1, 'permission_center', 'Permission Center', null);

-- resource
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (1, 1, 1, now(), now(), 1, 'pc_system_management', 'System Management', null, 1, 'permission_center', null, 1, 0);
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (2, 1, 1, now(), now(), 1, 'pc_system_list', 'System List', null, 1, 'permission_center', null, 2, 1);
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (3, 1, 1, now(), now(), 1, 'pc_user_management', 'User Management', null, 1, 'permission_center', null, 1, 0);
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (4, 1, 1, now(), now(), 1, 'pc_user_management_list', 'User List', null, 1, 'permission_center', null, 2, 2);
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (5, 1, 1, now(), now(), 1, 'pc_role_management', 'Role Management', null, 1, 'permission_center', null, 1, 0);
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (6, 1, 1, now(), now(), 1, 'pc_role_list', 'Role List', null, 1, 'permission_center', null, 2, 4);
INSERT INTO resource (id, creator_id, modifier_id, create_time, update_time, version, code, name, description, type, system_code, url, level, parent_id) VALUES (7, 1, 1, now(), now(), 1, 'pc_user_role_management', 'User Role Management', null, 1, 'permission_center', null, 2, 4);

-- role
INSERT INTO role (id, creator_id, modifier_id, create_time, update_time, version, code, name, description) VALUES (1, 1, 1, now(), now(), 1, 'super_user', 'Super User', null);

-- user
INSERT INTO user (id, creator_id, modifier_id, create_time, update_time, version, user_id, email, name, password, status) VALUES (1, 0, 0, now(), now(), 1, 1, 'admin@pullock.fun', 'Admin', 'admin', 1);

-- user_role
INSERT INTO user_role (id, creator_id, modifier_id, create_time, update_time, user_id, role_code) VALUES (1, 1, 1, now(), now(), 1, 'super_user');