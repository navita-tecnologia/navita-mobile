    create table AdAuthContainer (
        id varchar(32) not null,
        dnsResolving smallint,
        domainName varchar(255),
        domainUser varchar(255),
        domainUserPassword varchar(255),
        groupAttribute varchar(255),
        groupFilter varchar(255),
        ip varchar(255),
        searchBase varchar(255),
        searchFilter varchar(255),
        url varchar(255),
        primary key (id)
    );

    create table Application (
        id varchar(32) not null,
        name varchar(255) not null,
        enabled smallint,
        licenseKey varchar(255),
        usingAnalytics smallint,
        licenseBundle_id varchar(32),
        primary key (id)
    );

    create table Application_Connector (
        Application_id varchar(32) not null,
        connectors_id varchar(32) not null,
        primary key (Application_id, connectors_id),
        unique (connectors_id)
    );

    create table Application_PushServer (
        Application_id varchar(32) not null,
        besPushServers_id varchar(32) not null,
        primary key (Application_id, besPushServers_id),
        unique (besPushServers_id)
    );

    create table AuthContainer (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table Connector (
        id varchar(32) not null,
        name varchar(255) not null,
        enabled smallint not null,
        licenseKey varchar(255) not null,
        tag varchar(255) not null unique,
        application_id varchar(32),
        authContainer_id varchar(32),
        licenseBundle_id varchar(32),
        tokenConnector_id varchar(32),
        primary key (id)
    );

    create table DataSourceConnector (
        id varchar(32) not null,
        dataSource varchar(255),
        primary key (id)
    );

    create table DataSourceQueryOperation (
        id varchar(32) not null,
        query varchar(5000),
        returnResultSet smallint,
        primary key (id)
    );

    create table EjbConnector (
        id varchar(32) not null,
        ejbName varchar(255),
        primary key (id)
    );

    create table LicenseActivation (
        id varchar(32) not null,
        name varchar(255) not null,
        activationDate timestamp,
        brand varchar(255),
        carrier varchar(255),
        email varchar(255),
        licenseKey varchar(255),
        model varchar(255),
        pin varchar(255),
        licenseBundle_id varchar(32),
        primary key (id)
    );

    create table LicenseBundle (
        id varchar(32) not null,
        name varchar(255) not null,
        enabled smallint not null,
        period integer not null,
        licenseBundleType_id varchar(32),
        primary key (id)
    );

    create table LicenseBundleType (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table Operation (
        id varchar(32) not null,
        name varchar(255) not null,
        licenseKey varchar(255),
        tag varchar(255),
        licenseBundle_id varchar(32),
        connector_id varchar(32),
        primary key (id)
    );

    create table ProxyConnector (
        id varchar(32) not null,
        url varchar(255),
        primary key (id)
    );

    create table PushServer (
        id varchar(32) not null,
        name varchar(255) not null,
        port varchar(255) not null,
        tag varchar(255) not null unique,
        url varchar(255) not null,
        application_id varchar(32),
        primary key (id)
    );

    create table SapConnector (
        id varchar(32) not null,
        asHost varchar(255) not null,
        client varchar(255) not null,
        lang varchar(255),
        router varchar(255),
        sysnr varchar(255) not null,
        primary key (id)
    );

    create table SapFunctionOperation (
        id varchar(32) not null,
        functionName varchar(255),
        primary key (id)
    );

    create table SapFunctionOperation_SapInputParameter (
        SapFunctionOperation_id varchar(32) not null,
        inputParameters_id varchar(32) not null,
        primary key (SapFunctionOperation_id, inputParameters_id),
        unique (inputParameters_id)
    );

    create table SapFunctionOperation_SapInputTable (
        SapFunctionOperation_id varchar(32) not null,
        inputTables_id varchar(32) not null,
        primary key (SapFunctionOperation_id, inputTables_id),
        unique (inputTables_id)
    );

    create table SapFunctionOperation_SapOutputParameter (
        SapFunctionOperation_id varchar(32) not null,
        outputParameters_id varchar(32) not null,
        primary key (SapFunctionOperation_id, outputParameters_id),
        unique (outputParameters_id)
    );

    create table SapFunctionOperation_SapOutputTable (
        SapFunctionOperation_id varchar(32) not null,
        outputTables_id varchar(32) not null,
        primary key (SapFunctionOperation_id, outputTables_id),
        unique (outputTables_id)
    );

    create table SapParameter (
        id varchar(32) not null,
        name varchar(255) not null,
        value varchar(255) not null,
        primary key (id)
    );

    create table SapRow (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table SapRow_SapParameter (
        SapRow_id varchar(32) not null,
        attributes_id varchar(32) not null,
        primary key (SapRow_id, attributes_id),
        unique (attributes_id)
    );

    create table SapTable (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table SapTableField (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table SapTable_SapRow (
        SapTable_id varchar(32) not null,
        sapRows_id varchar(32) not null,
        primary key (SapTable_id, sapRows_id),
        unique (sapRows_id)
    );

    create table SapTable_SapTableField (
        SapTable_id varchar(32) not null,
        fieldNames_id varchar(32) not null,
        primary key (SapTable_id, fieldNames_id),
        unique (fieldNames_id)
    );

    create table StaticConnector (
        id varchar(32) not null,
        primary key (id)
    );

    create table StaticOperation (
        id varchar(32) not null,
        list varchar(255),
        message varchar(255),
        object varchar(255),
        resultCode integer,
        token varchar(255),
        primary key (id)
    );

    create table WebServiceConnector (
        id varchar(32) not null,
        wsdl varchar(255),
        primary key (id)
    );

    alter table AdAuthContainer 
        add constraint FK33385836CE68831D 
        foreign key (id) 
        references AuthContainer;

    alter table Application 
        add constraint FKC00DAD30F937C543 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table Application_Connector 
        add constraint FK47A7FFDEC7F3B843 
        foreign key (Application_id) 
        references Application;

    alter table Application_Connector 
        add constraint FK47A7FFDECB9F494A 
        foreign key (connectors_id) 
        references Connector;

    alter table Application_PushServer 
        add constraint FK3A11F58CC7F3B843 
        foreign key (Application_id) 
        references Application;

    alter table Application_PushServer 
        add constraint FK3A11F58C3B7BB6A8 
        foreign key (besPushServers_id) 
        references PushServer;

    alter table Connector 
        add constraint FK54EC142DD57D15DC 
        foreign key (tokenConnector_id) 
        references Connector;

    alter table Connector 
        add constraint FK54EC142DC7F3B843 
        foreign key (application_id) 
        references Application;

    alter table Connector 
        add constraint FK54EC142DF937C543 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table Connector 
        add constraint FK54EC142D15566143 
        foreign key (authContainer_id) 
        references AuthContainer;

    alter table DataSourceConnector 
        add constraint FKEC68A148DFCC9831 
        foreign key (id) 
        references Connector;

    alter table DataSourceQueryOperation 
        add constraint FKA0A67564656D794B 
        foreign key (id) 
        references Operation;

    alter table EjbConnector 
        add constraint FK929CF890DFCC9831 
        foreign key (id) 
        references Connector;

    alter table LicenseActivation 
        add constraint FKF36D8417F937C543 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table LicenseBundle 
        add constraint FKA1D5DC03D4AE4AA3 
        foreign key (licenseBundleType_id) 
        references LicenseBundleType;

    alter table Operation 
        add constraint FKDA8CF54752C28963 
        foreign key (connector_id) 
        references Connector;

    alter table Operation 
        add constraint FKDA8CF547F937C543 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table ProxyConnector 
        add constraint FKB884F19FDFCC9831 
        foreign key (id) 
        references Connector;

    alter table PushServer 
        add constraint FKD5506B1DC7F3B843 
        foreign key (application_id) 
        references Application;

    alter table SapConnector 
        add constraint FK1E4DEAABDFCC9831 
        foreign key (id) 
        references Connector;

    alter table SapFunctionOperation 
        add constraint FKBE850CCD656D794B 
        foreign key (id) 
        references Operation;

    alter table SapFunctionOperation_SapInputParameter 
        add constraint FK82C5306F405BEE84 
        foreign key (inputParameters_id) 
        references SapParameter;

    alter table SapFunctionOperation_SapInputParameter 
        add constraint FK82C5306FB85F0FF1 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapFunctionOperation_SapInputTable 
        add constraint FKAC700B941DABC1CE 
        foreign key (inputTables_id) 
        references SapTable;

    alter table SapFunctionOperation_SapInputTable 
        add constraint FKAC700B94B85F0FF1 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapFunctionOperation_SapOutputParameter 
        add constraint FK519CE838880E1EAD 
        foreign key (outputParameters_id) 
        references SapParameter;

    alter table SapFunctionOperation_SapOutputParameter 
        add constraint FK519CE838B85F0FF1 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapFunctionOperation_SapOutputTable 
        add constraint FKC1650FDD41466E77 
        foreign key (outputTables_id) 
        references SapTable;

    alter table SapFunctionOperation_SapOutputTable 
        add constraint FKC1650FDDB85F0FF1 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapRow_SapParameter 
        add constraint FKE0BC702EC6A36471 
        foreign key (SapRow_id) 
        references SapRow;

    alter table SapRow_SapParameter 
        add constraint FKE0BC702E9E2F1381 
        foreign key (attributes_id) 
        references SapParameter;

    alter table SapTable_SapRow 
        add constraint FK42E1D12B737C4E31 
        foreign key (SapTable_id) 
        references SapTable;

    alter table SapTable_SapRow 
        add constraint FK42E1D12B921FDF8E 
        foreign key (sapRows_id) 
        references SapRow;

    alter table SapTable_SapTableField 
        add constraint FK7F55E15B737C4E31 
        foreign key (SapTable_id) 
        references SapTable;

    alter table SapTable_SapTableField 
        add constraint FK7F55E15B7AE85203 
        foreign key (fieldNames_id) 
        references SapTableField;

    alter table StaticConnector 
        add constraint FK35E7595FDFCC9831 
        foreign key (id) 
        references Connector;

    alter table StaticOperation 
        add constraint FKBB883A79656D794B 
        foreign key (id) 
        references Operation;

    alter table WebServiceConnector 
        add constraint FKE0B4B86CDFCC9831 
        foreign key (id) 
        references Connector;

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
        
create table CONTROLTB (f smallint);

insert into CONTROLTB values(1);