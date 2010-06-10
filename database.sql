CREATE TABLE licenseBundleType(
	id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name varchar(100) NOT NULL 
); 

CREATE TABLE deviceData(
	pin varchar(50) NOT NULL PRIMARY KEY,
	model varchar(100) ,
	brand varchar(100) ,
	lastEmail varchar(255) ,
	lastCarrier varchar(100) 
);

CREATE TABLE mobileapp(
	id varchar(255) NOT NULL PRIMARY KEY,
	name varchar(100) NOT NULL,
	enabled int NOT NULL,
	url varchar(255) ,
	internal int NOT NULL,
	usingNativeLoginService int NOT NULL,
	loginServiceId varchar(100) ,
	privateKey varchar(255) ,
	tokenGeneratorUrl varchar(255) 
); 

CREATE TABLE mobileappexecutor(
	name varchar(255) ,
	classname varchar(255) ,
	configuration varchar(5000) ,
	mobileid varchar(255) 
); 

CREATE TABLE mobileconfig(
	id varchar(255) NOT NULL PRIMARY KEY,
	value varchar(255) 
); 

CREATE TABLE licenseBundle(
	name varchar(50) NOT NULL,
	typeId int NOT NULL,
	enabled INT NOT NULL,
	defaultPeriodInDays int NOT NULL,
	id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
); 

CREATE TABLE users(
	username varchar(50) NOT NULL PRIMARY KEY,
	password varchar(50) NOT NULL,
	enabled int NOT NULL

) ;

CREATE TABLE licenseUse(
	id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	bundleId int NOT NULL,
	pin varchar(50) NOT NULL,
	activationDate TIMESTAMP NOT NULL,
	periodInDays int NOT NULL,
	licenseKey varchar(500) ,
	email varchar(255) 
) ;

CREATE TABLE authorities(
	username varchar(50) NOT NULL,
	authority varchar(50) NOT NULL
) ;

ALTER TABLE authorities ADD  CONSTRAINT fk_authorities_users FOREIGN KEY(username)
REFERENCES users (username);

ALTER TABLE licenseUse  ADD  CONSTRAINT FK_licenseUse_deviceData FOREIGN KEY(pin)
REFERENCES deviceData (pin);

ALTER TABLE licenseUse  ADD  CONSTRAINT fk_licenseuse_licensebundle FOREIGN KEY(bundleId)
REFERENCES licenseBundle (id);

INSERT INTO USERS VALUES('admin','972bfefb9b804dedbb79c02caf7d818a',1);
INSERT INTO AUTHORITIES VALUES('admin','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('admin','ROLE_ADMINISTRATOR');


