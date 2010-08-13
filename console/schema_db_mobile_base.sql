CREATE TABLE users(
	username varchar(50) NOT NULL PRIMARY KEY,
	password varchar(50) NOT NULL,
	enabled int NOT NULL

) ;
CREATE TABLE authorities(
	username varchar(50) NOT NULL,
	authority varchar(50) NOT NULL
) ;

ALTER TABLE authorities ADD  CONSTRAINT fk_authorities_users FOREIGN KEY(username)
REFERENCES users (username);



--legacy
CREATE TABLE mobileapp(
	id varchar(255) NOT NULL PRIMARY KEY,
	name varchar(100) NOT NULL,
	enabled int NOT NULL,
	url varchar(255) ,	
	usingNativeLoginService int NOT NULL,
	loginServiceId varchar(100) ,
	privateKey varchar(255) ,
	tokenGeneratorUrl varchar(255),
	licenseBundleId varchar(100),
	licenseActivationKey varchar(500)
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



INSERT INTO USERS VALUES('admin','972bfefb9b804dedbb79c02caf7d818a',1);

INSERT INTO AUTHORITIES VALUES('admin','ROLE_USER');

INSERT INTO AUTHORITIES VALUES('admin','ROLE_ADMINISTRATOR');


insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61439','Consumer Free');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61440','Consumer Payed by PIN');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61441','Consumer Payed by PIN Bundle');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61442','Consumer Free by PIN');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61443','Entreprise Free');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61444','Entreprise by Application');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61445','Enterprise by Operation');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61446','Entreprise by Application and PIN');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61447','Entreprise by Operation and PIN');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61448','Entreprise by Connector');

insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61449','Entreprise by Connector and PIN');

insert into LICENSEBUNDLE values('cdf2b0011b0b4fc39490baa776d61450','Teste Bundle',1,30,'cdf2b0011b0b4fc39490baa776d61444');
