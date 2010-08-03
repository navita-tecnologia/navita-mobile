
    alter table AdLoginService 
        drop constraint FKF24106EF82C77F8C;

    alter table Connector 
        drop constraint FK54EC142DA338379F;

    alter table Connector 
        drop constraint FK54EC142DC8E257F;

    alter table Connector 
        drop constraint FK54EC142D4D364D86;

    alter table Connector_Operation 
        drop constraint FKA9E46FB5207DAB26;

    alter table Connector_Operation 
        drop constraint FKA9E46FB538B21041;

    alter table LicenseActivation 
        drop constraint FKF36D84174D364D86;

    alter table LicenseBundle 
        drop constraint FKA1D5DC0379D8F966;

    alter table StaticConnector 
        drop constraint FK35E7595FAD87B9F4;

    alter table StaticOperation 
        drop constraint FKBB883A7933289B0E;

    alter table StaticOperation 
        drop constraint FKBB883A799EC58C6;

    drop table AdLoginService;

    drop table BaseLoginService;

    drop table Connector;

    drop table Connector_Operation;

    drop table LicenseActivation;

    drop table LicenseBundle;

    drop table LicenseBundleType;

    drop table Operation;

    drop table StaticConnector;

    drop table StaticOperation;

    create table AdLoginService (
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

    create table BaseLoginService (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table Connector (
        id varchar(32) not null,
        name varchar(255) not null,
        enabled smallint not null,
        licenseKey varchar(255) not null,
        tag varchar(255) not null,
        loginService_id varchar(32),
        tokenConnector_id varchar(32),
        licenseBundle_id varchar(32),
        primary key (id)
    );

    create table Connector_Operation (
        Connector_id varchar(32) not null,
        operations_id varchar(32) not null,
        primary key (Connector_id, operations_id),
        unique (operations_id)
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
        licenseBundle varchar(255) for bit data,
        licenseKey varchar(255),
        primary key (id)
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
        staticConnector_id varchar(32),
        primary key (id)
    );

    alter table AdLoginService 
        add constraint FKF24106EF82C77F8C 
        foreign key (id) 
        references BaseLoginService;

    alter table Connector 
        add constraint FK54EC142DA338379F 
        foreign key (tokenConnector_id) 
        references Connector;

    alter table Connector 
        add constraint FK54EC142DC8E257F 
        foreign key (loginService_id) 
        references BaseLoginService;

    alter table Connector 
        add constraint FK54EC142D4D364D86 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table Connector_Operation 
        add constraint FKA9E46FB5207DAB26 
        foreign key (Connector_id) 
        references Connector;

    alter table Connector_Operation 
        add constraint FKA9E46FB538B21041 
        foreign key (operations_id) 
        references Operation;

    alter table LicenseActivation 
        add constraint FKF36D84174D364D86 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table LicenseBundle 
        add constraint FKA1D5DC0379D8F966 
        foreign key (licenseBundleType_id) 
        references LicenseBundleType;

    alter table StaticConnector 
        add constraint FK35E7595FAD87B9F4 
        foreign key (id) 
        references Connector;

    alter table StaticOperation 
        add constraint FKBB883A7933289B0E 
        foreign key (id) 
        references Operation;

    alter table StaticOperation 
        add constraint FKBB883A799EC58C6 
        foreign key (staticConnector_id) 
        references StaticConnector;
