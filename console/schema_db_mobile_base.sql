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

INSERT INTO USERS VALUES('admin','972bfefb9b804dedbb79c02caf7d818a',1);
INSERT INTO AUTHORITIES VALUES('admin','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('admin','ROLE_ADMINISTRATOR');


insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61439','Consumer Free',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61440','Consumer Payed by PIN',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61441','Consumer Payed by PIN Bundle',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61442','Consumer Free by PIN',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61443','Entreprise Free',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61444','Entreprise by Application',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61445','Enterprise by Operation',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61446','Entreprise by Application and PIN',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61447','Entreprise by Operation and PIN',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61448','Entreprise by Connector',0);
insert into LicenseBundleType values ('cdf2b0011b0b4fc39490baa776d61449','Entreprise by Connector and PIN',0);