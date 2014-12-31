INSERT INTO user_types VALUES (1, 'SuperAdmin');
INSERT INTO user_types VALUES (2, 'ExpertL3');
INSERT INTO user_types VALUES (3, 'ExpertL2');
INSERT INTO user_types VALUES (4, 'CustomerAdmin');
INSERT INTO user_types VALUES (5, 'Hypervisor');
INSERT INTO user_types VALUES (6, 'Supervisor'); 

INSERT INTO customers VALUES ('Orange', 'Default value for Orange Experts and SuperAdmin');

INSERT INTO `users` VALUES (1,'SuperAdmin','$2a$10$W39l39tzvAqnJyHPWGdpeOH0KVb6I1sLgGveJuIbbwq6eW6KNEceW',1,1,NULL,'2014-12-09 23:01:51',1,'2014-12-09 23:01:51',NULL,NULL);
/*password = 'password'*/ 

INSERT INTO `hcsportal`.`users`
(`username`,
`password`,
`user_type_id`,
`customer_id`,
`created_by`,
`creation_time`,
`enabled`,
`last_logged_in`,
`first_name`,
`last_name`)
VALUES('Expert1', '$2a$10$W39l39tzvAqnJyHPWGdpeOH0KVb6I1sLgGveJuIbbwq6eW6KNEceW', 2, 1, 1, CURRENT_TIMESTAMP,true, NULL, 'expertL3', 'EXPERTL3');


/******** TEST **********/
INSERT INTO tenants(tenant_name, customer_id, ip_address, description) VALUES ('cust1-tenant1', 2, '172.111.222.000', 'Tenant 1 test');

INSERT INTO equipment (`tenant_id`,
`equipment_name`,
`ip_address`,
`serial_number`,
`machine_type`,
`is_virtualized`,
`operating_system`,
`app_version`,
`hardware`, `geo_location`, `description`) 
VALUES (1, 'equip1', '172.111.222.1', 'serial4', 'type2', 1, 'os2', 'version2','hard1', 'DataCenter1', 'test server');


INSERT INTO `hcsportal`.`services`
(`service_code`,`tenant_id`,`emergency`,`description`)
VALUES ('Engineering', 1, false, 'tenant1-service1');

INSERT INTO `hcsportal`.`services`
(`service_code`,`tenant_id`,`emergency`,`description`)
VALUES ('Pre-sale', 1, false, 'tenant1-service2');

INSERT INTO weekly_schedules
(`schedule_name`,`tenant_id`,`created_by`,`description`,
`mon_open_1`,`mon_close_1`,`mon_open_2`,`mon_close_2`,
`tue_open_1`,`tue_close_1`,`tue_open_2`,`tue_close_2`,
`wed_open_1`,`wed_close_1`,`wed_open_2`,`wed_close_2`,
`thu_open_1`,`thu_close_1`,`thu_open_2`,`thu_close_2`,
`fri_open_1`,`fri_close_1`,`fri_open_2`,`fri_close_2`,
`sat_open_1`,`sat_close_1`,`sat_open_2`,`sat_close_2`,
`sun_open_1`,`sun_close_1`,`sun_open_2`,`sun_close_2`)
VALUES ('test-schedule', 1, 5, 'test test', 
'8:00', '18:00', null, null, 
'8:00', '18:00', null, null,
'8:00', '18:00', null, null,
'8:00', '18:00', null, null, 
'8:00', '18:00', null, null, 
'8:00', '12:00', '14:00', '18:00',
'8:00', '12:00', '14:00', '18:00');


INSERT INTO `hcsportal`.`sites`
(`site_code`,`service_id`,`location_id`,`schedule_id`,`emergency`,`description`)
VALUES ('Site_Paris', 1, 1, 1, false, 'test site 1');
---------------------------------------------
INSERT INTO locations(country, city, time_zone) VALUES ('France', 'Paris', '+1:00');
INSERT INTO locations(country, city, time_zone) VALUES ('UK', 'London', '+0:00');

INSERT INTO services(service_code, customer_id, location_id, emergency_state) VALUES ('Serv_FRA_1', 9, 1, false); 
INSERT INTO services(service_code, customer_id, location_id, emergency_state) VALUES ('Serv_UK_1', 9, 2, false); 

INSERT INTO weekdays VALUES (2, 1, '8:00', '18:00', null, null);
INSERT INTO weekdays VALUES (2, 2, '8:00', '18:00', null, null);
INSERT INTO weekdays VALUES (2, 3, '8:00', '18:00', null, null);
INSERT INTO weekdays VALUES (2, 4, '8:00', '18:00', null, null);
INSERT INTO weekdays VALUES (2, 5, '8:00', '18:00', null, null);

INSERT INTO weekdays VALUES (3, 1, '8:00', '12:00', '14:00', '18:00');
INSERT INTO weekdays VALUES (3, 2, '8:00', '12:00', '14:00', '18:00');

INSERT INTO holidays VALUES (2, '2014-11-11', 'Armistice');
INSERT INTO holidays VALUES (2, '2014-12-25', 'Noël');
INSERT INTO holidays VALUES (3, '2014-12-25', 'Christmas');

INSERT INTO exceptional_days VALUES(2, '2014-11-11', '10:00', '16:00', null, null, 'exception');