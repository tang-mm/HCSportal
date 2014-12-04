DROP TABLE IF EXISTS ip_shared_management_components;
DROP TABLE IF EXISTS ip_suffix_customer_components;
DROP TABLE IF EXISTS pin_codes;
DROP TABLE IF EXISTS audio_message_service;
DROP TABLE IF EXISTS audio_messages;
DROP TABLE IF EXISTS audio_message_types;
DROP TABLE IF EXISTS user_tenant_permissions;
DROP TABLE IF EXISTS user_service_permissions;
DROP TABLE IF EXISTS user_site_permissions;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS holidays;
DROP TABLE IF EXISTS exceptional_days;
DROP TABLE IF EXISTS sites;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS weekly_schedules;
DROP TABLE IF EXISTS tenants;
DROP TABLE IF EXISTS users ;
DROP TABLE IF EXISTS user_types ;
DROP TABLE IF EXISTS customers ;


CREATE TABLE customers (
	customer_id int unsigned AUTO_INCREMENT,
	customer_name varchar(32) NOT NULL UNIQUE,
	description varchar(1000),
	PRIMARY KEY (customer_id)
);
ALTER TABLE customers AUTO_INCREMENT = 0;  /* Start incrementing from 0 --> value reserved for OBS */

CREATE INDEX idx_customers_customer_name ON customers(customer_name);


CREATE TABLE tenants (
	tenant_id int unsigned AUTO_INCREMENT,
	tenant_name varchar(32) NOT NULL UNIQUE,
	customer_id int unsigned NOT NULL,
	ip_address varchar(15) NOT NULL UNIQUE,
	description varchar(1000),
	PRIMARY KEY (tenant_id),
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE
);
CREATE INDEX idx_tenants_tenant_name ON tenants(tenant_name);


CREATE TABLE user_types (
	user_type_id int unsigned,
	user_type varchar(32) NOT NULL UNIQUE,
	PRIMARY KEY (user_type_id)
);
CREATE INDEX idx_user_types_user_type ON user_types(user_type); 


CREATE TABLE users (
	user_id int unsigned AUTO_INCREMENT,
	username varchar(32) NOT NULL,
	password varchar(32) NOT NULL,  
	user_type_id int unsigned NOT NULL, 
	customer_id int unsigned NOT NULL, 	 	/* value = 0 if OBS experts or superadmin */
	created_by int unsigned NULL,
	creation_time TIMESTAMP NOT NULL,
	enabled boolean NOT NULL,
	last_logged_in TIMESTAMP,
	first_name varchar(32),
	last_name varchar(32),
	PRIMARY KEY (user_id),
	FOREIGN KEY (user_type_id) REFERENCES user_types(user_type_id) ON UPDATE CASCADE,
	FOREIGN KEY (created_by) REFERENCES users(user_id) ON UPDATE CASCADE,
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE
);
CREATE UNIQUE INDEX idx_users_username_customer_id ON users(username, customer_id);
CREATE INDEX idx_users_user_type_id ON users(user_type_id);
CREATE INDEX idx_users_customer_id ON users(customer_id);


CREATE TABLE services (
	service_id int unsigned AUTO_INCREMENT,
	service_code varchar(32) NOT NULL,
	tenant_id int unsigned NOT NULL,
	emergency boolean NOT NULL,
	description varchar(256),
	PRIMARY KEY (service_id),
	FOREIGN KEY (tenant_id) REFERENCES tenants(tenant_id) ON UPDATE CASCADE,
    CONSTRAINT UNIQUE (service_code, tenant_id)
);
CREATE INDEX idx_services_service_code ON services(service_code); 
CREATE INDEX idx_services_tenant_id ON services(tenant_id); 


CREATE TABLE locations (
	location_id int unsigned AUTO_INCREMENT,
	country varchar(32) NOT NULL,
	state varchar(32),
	city varchar(32) NOT NULL,
	time_zone varchar(32) NOT NULL,
    PRIMARY KEY (location_id)
);
CREATE UNIQUE INDEX idx_locations_country_city ON locations(country, city);


CREATE TABLE weekly_schedules (
	schedule_id int unsigned AUTO_INCREMENT,
	schedule_name varchar(32) NOT NULL,
	tenant_id int unsigned NOT NULL,
	created_by int unsigned NOT NULL,	/* user id */
	description varchar(256) NOT NULL,
	mon_open_1 time DEFAULT NULL,
	mon_close_1 time DEFAULT NULL,
	mon_open_2 time DEFAULT NULL,
	mon_close_2 time DEFAULT NULL,
	tue_open_1 time DEFAULT NULL,
	tue_close_1 time DEFAULT NULL,
	tue_open_2 time DEFAULT NULL,
	tue_close_2 time DEFAULT NULL,
	wed_open_1 time DEFAULT NULL,
	wed_close_1 time DEFAULT NULL,
	wed_open_2 time DEFAULT NULL,
	wed_close_2 time DEFAULT NULL,
	thu_open_1 time DEFAULT NULL,
	thu_close_1 time DEFAULT NULL,
	thu_open_2 time DEFAULT NULL,
	thu_close_2 time DEFAULT NULL,
	fri_open_1 time DEFAULT NULL,
	fri_close_1 time DEFAULT NULL,
	fri_open_2 time DEFAULT NULL,
	fri_close_2 time DEFAULT NULL,
	sat_open_1 time DEFAULT NULL,
	sat_close_1 time DEFAULT NULL,
	sat_open_2 time DEFAULT NULL,
	sat_close_2 time DEFAULT NULL,
	sun_open_1 time DEFAULT NULL,
	sun_close_1 time DEFAULT NULL,
	sun_open_2 time DEFAULT NULL,
	sun_close_2 time DEFAULT NULL,
	PRIMARY KEY (schedule_id),
	FOREIGN KEY (tenant_id) REFERENCES tenants(tenant_id) ON UPDATE CASCADE,
	FOREIGN KEY (created_by) REFERENCES users(user_id) ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (schedule_name, tenant_id)
);
CREATE INDEX idx_weekly_schedules_tenant_id ON weekly_schedules(tenant_id);
CREATE INDEX idx_weekly_schedules_schedule_name ON weekly_schedules(schedule_name);


CREATE TABLE sites (
	site_id int unsigned AUTO_INCREMENT,
	site_code varchar(32) NOT NULL,
	service_id int unsigned NOT NULL,
	location_id int unsigned NOT NULL,
	schedule_id int unsigned NOT NULL,
	emergency boolean NOT NULL,
	description varchar(256),
	PRIMARY KEY (site_id),
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE,
	FOREIGN KEY (location_id) REFERENCES locations(location_id) ON UPDATE CASCADE,
    FOREIGN KEY (schedule_id) REFERENCES weekly_schedules(schedule_id) ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (site_code, service_id)
);
CREATE INDEX idx_sites_site_code ON sites(site_code);
CREATE INDEX idx_sites_service_id ON sites(service_id);
CREATE INDEX idx_sites_location_id ON sites(location_id);
CREATE INDEX idx_sties_schedule_id ON sites(schedule_id);
 

/*CREATE TABLE weekdays ( 
    service_id int unsigned,
	weekday int unsigned NOT NULL,  -- {1, .. 7}, Monday = 1, ..., Sunday = 7 
	open_time_1 time DEFAULT NULL,
	close_time_1 time DEFAULT NULL,
	open_time_2 time DEFAULT NULL, 
	close_time_2 time DEFAULT NULL,
	PRIMARY KEY (service_id, weekday),
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE
);
*/

CREATE TABLE holidays (
	holiday_id int unsigned AUTO_INCREMENT,
	site_id int unsigned,
	holiday date NOT NULL,
	description varchar(32), 
	PRIMARY KEY (holiday_id),
	FOREIGN KEY (site_id) REFERENCES sites(site_id) ON UPDATE CASCADE,
	CONSTRAINT UNIQUE  (site_id, holiday)
);
CREATE INDEX idx_holidays_holiday ON holidays(holiday);


CREATE TABLE exceptional_days (
	exception_id int unsigned AUTO_INCREMENT,
	site_id int unsigned,
	exception_date date NOT NULL,
	open_time_1 time DEFAULT NULL,
	close_time_1 time DEFAULT NULL,
	open_time_2 time DEFAULT NULL, 
	close_time_2 time DEFAULT NULL,
	description varchar(32),
	PRIMARY KEY (exception_id), 
	FOREIGN KEY (site_id) REFERENCES sites(site_id) ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (site_id, exception_date)
);
CREATE INDEX idx_exceptional_days_date ON exceptional_days(exception_date);


CREATE TABLE pin_codes(
	pin_code_id bigint unsigned AUTO_INCREMENT,
	service_id int unsigned NOT NULL,
	caller_name varchar(32) NOT NULL,
	pin_code varchar(10) NOT NULL,
	target1_agent1_username varchar(32),
	target2_agent2_username varchar(32),
	target3_agent3_username varchar(32),
	target4_skill_group1 varchar(32),
	target5_skill_group2 varchar(32),
	target6_supervisor_username varchar(32),
	target7_voicemail varchar(32),
	free_text1 varchar(32),
	free_text2 varchar(32),
	PRIMARY KEY (pin_code_id),
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE, 
	CONSTRAINT UNIQUE (service_id, caller_name, pin_code)
);
CREATE UNIQUE INDEX idx_pin_codes_service_id_caller_name_pin_code ON pin_codes(service_id, caller_name, pin_code);
CREATE INDEX idx_pin_codes_caller_name ON pin_codes(caller_name);
CREATE INDEX idx_pin_codes_pin_code ON pin_codes(pin_code);


CREATE TABLE equipment(
	equipment_id int unsigned AUTO_INCREMENT,
	tenant_id int unsigned NOT NULL,
	equipment_name varchar(32) NOT NULL,
	ip_address varchar(15) NOT NULL UNIQUE,
	serial_number varchar(32) NOT NULL UNIQUE,
	machine_type varchar(32) NOT NULL,
	is_virtualized boolean NOT NULL,
	operating_system varchar(32) NOT NULL,
	app_version varchar(32) NOT NULL,
	hardware varchar(32) NOT NULL,
	geo_location varchar(32) NOT NULL,
	description varchar(256),
	PRIMARY KEY (equipment_id),
	FOREIGN KEY (tenant_id) REFERENCES tenants(tenant_id) ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (equipment_name, tenant_id)
);
CREATE INDEX idx_equipment_tenant_id ON equipment(tenant_id);
CREATE INDEX idx_equipment_equipment_name ON equipment(equipment_name);
CREATE INDEX idx_equipment_ip_address ON equipment(ip_address);
CREATE INDEX idx_equipment_serial_number ON equipment(serial_number);
CREATE INDEX idx_equipment_geo_location ON equipment(geo_location);


/************** Permissions ***************/
CREATE TABLE user_tenant_permissions (
	user_id int unsigned,
	tenant_id int unsigned,
	PRIMARY KEY (user_id, tenant_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
	FOREIGN KEY (tenant_id) REFERENCES tenants(tenant_id) ON UPDATE CASCADE
);

CREATE TABLE user_service_permissions (
	user_id int unsigned,
	service_id int unsigned,
	PRIMARY KEY (user_id, service_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE
);

CREATE TABLE user_site_permissions (
	user_id int unsigned,
	site_id int unsigned,
	PRIMARY KEY (user_id, site_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
	FOREIGN KEY (site_id) REFERENCES sites(site_id) ON UPDATE CASCADE
);


/************** Audio Message ***************/
CREATE TABLE audio_message_types (
	type_id int unsigned AUTO_INCREMENT,
	type_name varchar(32) NOT NULL UNIQUE,
	PRIMARY KEY (type_id)
);
CREATE INDEX idx_audio_message_types_type_name ON audio_message_types(type_name);


CREATE TABLE audio_messages (
	message_id int unsigned AUTO_INCREMENT,
	file_name varchar(32) NOT NULL,
	file_path varchar(256) NOT NULL,
	type_id int unsigned NOT NULL,
	PRIMARY KEY (message_id),
	FOREIGN KEY (type_id) REFERENCES audio_message_types(type_id) ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (file_name,type_id)
);
CREATE INDEX idx_audio_messages_file_name ON audio_messages(file_name);
CREATE INDEX idx_audio_messages_type_id ON audio_messages(type_id);


CREATE TABLE audio_message_service (
	service_id int unsigned NOT NULL,
	message_id int unsigned NOT NULL, 
	PRIMARY KEY (service_id, message_id),
	FOREIGN KEY (service_id) REFERENCES services(service_id) ON UPDATE CASCADE,
	FOREIGN KEY (message_id) REFERENCES audio_messages(message_id) ON UPDATE CASCADE
);

/************** IP ***************/
CREATE TABLE ip_shared_management_components(
	component_id int unsigned AUTO_INCREMENT,
	component_name varchar(32) NOT NULL,
	side varchar(8) NOT NULL,
	ip_address varchar(15) NOT NULL UNIQUE,
	url_suffix varchar(32),
	PRIMARY KEY (component_id)
);
CREATE UNIQUE INDEX idx_ip_shared_management_components_component_name_side ON ip_shared_management_components(component_name, side);


CREATE TABLE ip_suffix_customer_components(
	component_id int unsigned AUTO_INCREMENT,
	component_name varchar(32) NOT NULL,
	side varchar(8) NOT NULL,
	ip_suffix varchar(3) NOT NULL,
	url_suffix varchar(32),
	PRIMARY KEY (component_id),
	CONSTRAINT UNIQUE (component_name, side)
);
CREATE INDEX idx_ip_suffix_customer_components_component_name_side ON ip_suffix_customer_components(component_name, side);
