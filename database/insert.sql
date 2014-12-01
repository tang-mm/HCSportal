INSERT INTO user_types VALUES (1, 'SuperAdmin');
INSERT INTO user_types VALUES (2, 'Expert_L3');
INSERT INTO user_types VALUES (3, 'Expert_L2');
INSERT INTO user_types VALUES (4, 'Expert_L1');
INSERT INTO user_types VALUES (5, 'Admin');
INSERT INTO user_types VALUES (6, 'Supervisor');
INSERT INTO user_types VALUES (7, 'Agent'); 

INSERT INTO customers VALUES (0, 'OBS', '0', 'reserved for OBS Experts and Super Administrator');
--INSERT INTO customers(customer_name, ip_address, description) VALUES ('testCust', 'testip', 'testtest');

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