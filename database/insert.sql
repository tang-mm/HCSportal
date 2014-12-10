INSERT INTO user_types VALUES (1, 'SuperAdmin');
INSERT INTO user_types VALUES (2, 'ExpertL3');
INSERT INTO user_types VALUES (3, 'ExpertL2');
INSERT INTO user_types VALUES (4, 'CustomerAdmin');
INSERT INTO user_types VALUES (5, 'Hypervisor');
INSERT INTO user_types VALUES (6, 'Supervisor'); 

INSERT INTO customers VALUES ('Orange', 'Default value for Orange Experts and SuperAdmin');

INSERT INTO `users` VALUES (1,'SuperAdmin','$2a$10$W39l39tzvAqnJyHPWGdpeOH0KVb6I1sLgGveJuIbbwq6eW6KNEceW',1,1,NULL,'2014-12-09 23:01:51',1,'2014-12-09 23:01:51',NULL,NULL);
/*'password'*/

/******** TEST **********/
INSERT INTO equipment (`customer_id`,
`equipment_name`,
`ip_address`,
`serial_number`,
`machine_type`,
`is_virtualized`,
`operating_system`,
`app_version`,
`hardware`, `geo_location`) VALUES (9, '44444', 'ip4', 'serial4', 'type2', 1, 'os2', 'version2','hard1', 'DataCenter1');
 

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