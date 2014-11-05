DROP TABLE IF EXISTS ip_shared_management_components;
DROP TABLE IF EXISTS ip_suffix_customer_components;
DROP TABLE IF EXISTS pin_codes;
DROP TABLE IF EXISTS weekdays;
DROP TABLE IF EXISTS holidays;
DROP TABLE IF EXISTS exceptional_days;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS users ;
DROP TABLE IF EXISTS user_types ;
DROP TABLE IF EXISTS customers ;


CREATE TABLE customers (
	customer_id int AUTO_INCREMENT,
	customer_name varchar(40) NOT NULL UNIQUE,
	ip_address varchar(15) NOT NULL,
	description varchar(1000),
	PRIMARY KEY (customer_id)
);
ALTER TABLE customers AUTO_INCREMENT = 0;  /* Start incrementing from 0 --> value reserved for OBS */

CREATE INDEX idx_customers_customer_name ON customers(customer_name);


CREATE TABLE user_types (
	user_type_id int,
	user_type varchar(20) NOT NULL UNIQUE,
	PRIMARY KEY (user_type_id)
);
CREATE INDEX idx_user_types_user_type ON user_types(user_type); 


CREATE TABLE users (
	user_id bigint unsigned AUTO_INCREMENT,
	username varchar(20) NOT NULL UNIQUE,
	password varchar(20) NOT NULL,  
	user_type_id int NOT NULL, 
	customer_id int NOT NULL, 	 	/* value = 0 if OBS experts or superadmin */
	created_by bigint unsigned NOT NULL,
	creation_time TIMESTAMP NOT NULL,
	enabled boolean NOT NULL,
	PRIMARY KEY (user_id),
	FOREIGN KEY (user_type_id) REFERENCES user_types(user_type_id) ON UPDATE CASCADE,
	FOREIGN KEY (created_by) REFERENCES users(user_id) ON UPDATE CASCADE,
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE
);
CREATE UNIQUE INDEX idx_users_username_customer_id ON users(username, customer_id);
CREATE INDEX idx_users_user_type_id ON users(user_type_id);
CREATE INDEX idx_users_customer_id ON users(customer_id);


CREATE TABLE locations (
	location_id bigint unsigned AUTO_INCREMENT,
	country varchar(20) NOT NULL,
	state varchar(20),
	city varchar(20) NOT NULL,
	time_zone varchar(20) NOT NULL,
    PRIMARY KEY (location_id)
);
CREATE UNIQUE INDEX idx_locations_country_city ON locations(country, city);


CREATE TABLE services (
	service_id bigint unsigned AUTO_INCREMENT,
	service_code varchar(20) NOT NULL UNIQUE,
	customer_id int NOT NULL,
	location_id bigint unsigned NOT NULL,
	emergency_state boolean NOT NULL,
	PRIMARY KEY (service_id),
	FOREIGN KEY (location_id) REFERENCES locations(location_id) ON UPDATE CASCADE,
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE,
    CONSTRAINT UNIQUE (service_code, customer_id)
);
CREATE UNIQUE INDEX idx_services_service_code_customer_id ON services(service_code, customer_id); 



CREATE TABLE weekdays ( 
    service_id bigint unsigned,
	weekday int unsigned NOT NULL, /* {1, .. 7}, Monday = 1, ..., Sunday = 7 */
	open_time_1 time DEFAULT NULL,
	close_time_1 time DEFAULT NULL,
	open_time_2 time DEFAULT NULL, 
	close_time_2 time DEFAULT NULL,
	PRIMARY KEY (service_id, weekday),
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE
);


CREATE TABLE holidays (
	service_id bigint unsigned,
	holiday date NOT NULL,
	description varchar(50), 
	PRIMARY KEY (service_id, holiday),
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE
);
CREATE INDEX idx_holidays_holiday ON holidays(holiday);


CREATE TABLE exceptional_days (
	service_id bigint unsigned,
	exception_date date NOT NULL,
	description varchar(50),
	PRIMARY KEY (service_id, exception_date), 
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE
);
CREATE INDEX idx_exceptional_day_day ON exceptional_days(exception_date);


CREATE TABLE pin_codes(
	pin_code_id bigint unsigned AUTO_INCREMENT,
	service_code varchar(20) NOT NULL,
	caller_name varchar(20) NOT NULL,
	pin_code varchar(10) NOT NULL,
	target1_agent1_username varchar(20),
	target2_agent2_username varchar(20),
	target3_agent3_username varchar(20),
	target4_skill_group1 varchar(20),
	target5_skill_group2 varchar(20),
	target6_supervisor_username varchar(20),
	target7_voicemail varchar(20),
	free_text1 varchar(20),
	free_text2 varchar(20),
	PRIMARY KEY (pin_code_id),
	FOREIGN KEY (service_code) REFERENCES services(service_code) ON UPDATE CASCADE, 
	CONSTRAINT UNIQUE (service_code, caller_name, pin_code)
);
CREATE UNIQUE INDEX idx_pin_codes_service_code_caller_name_pin_code ON pin_codes(service_code, caller_name, pin_code);
CREATE INDEX idx_pin_codes_caller_name ON pin_codes(caller_name);
CREATE INDEX idx_pin_codes_pin_code ON pin_codes(pin_code);


CREATE TABLE equipment(
	equipment_id bigint unsigned AUTO_INCREMENT,
	customer_id int NOT NULL,
	equipment_name varchar(20) NOT NULL UNIQUE,
	ip_address varchar(15) NOT NULL UNIQUE,
	serial_number varchar(20) NOT NULL UNIQUE,
	machine_type varchar(20) NOT NULL,
	is_virtualized boolean NOT NULL,
	operating_system varchar(20) NOT NULL,
	app_version varchar(20) NOT NULL,
	hardware varchar(20) NOT NULL,
	geo_location varchar(20) NOT NULL,
	PRIMARY KEY (equipment_id),
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE
);
CREATE INDEX idx_equipment_customer_id ON equipment(customer_id);
CREATE INDEX idx_equipment_equipment_name ON equipment(equipment_name);
CREATE INDEX idx_equipment_ip_address ON equipment(ip_address);
CREATE INDEX idx_equipment_serial_number ON equipment(serial_number);
CREATE INDEX idx_equipment_geo_location ON equipment(geo_location);


CREATE TABLE ip_shared_management_components(
	component_id int,
	component_name varchar(20) NOT NULL,
	side varchar(10) NOT NULL,
	ip_address varchar(15) NOT NULL UNIQUE,
	url_suffix varchar(20),
	PRIMARY KEY (component_id)
);
CREATE UNIQUE INDEX idx_ip_shared_management_components_component_name_side ON ip_shared_management_components(component_name, side);


CREATE TABLE ip_suffix_customer_components(
	component_id int,
	component_name varchar(20) NOT NULL,
	side varchar(10) NOT NULL,
	ip_suffix varchar(3) NOT NULL,
	url_suffix varchar(20),
	PRIMARY KEY (component_id)
);
CREATE UNIQUE INDEX idx_ip_suffix_customer_components_component_name_side ON ip_suffix_customer_components(component_name, side);
