drop database mobiledb;
create database mobiledb;
use mobiledb;
    alter table AdLoginService 
        drop constraint FKF24106EFC144AB30;

    alter table Connector 
        drop constraint FK54EC142D12B51C7B;

    alter table Connector 
        drop constraint FK54EC142D4B0B5123;

    alter table Connector 
        drop constraint FK54EC142D37BD6462;

    alter table Connector_Operation 
        drop constraint FKA9E46FB58FFA9002;

    alter table Connector_Operation 
        drop constraint FKA9E46FB5A82EF51D;

    alter table LicenseActivation 
        drop constraint FKF36D841737BD6462;

    alter table LicenseBundle 
        drop constraint FKA1D5DC03B014242;

    alter table StaticConnector 
        drop constraint FK35E7595F1D049ED0;

    alter table StaticOperation 
        drop constraint FKBB883A79A2A57FEA;

    alter table StaticOperation 
        drop constraint FKBB883A796F0928A2;

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
        primary key (id)
    );

    create table BaseLoginService (
        id varchar(32) not null,
        name varchar(255) not null,
        removed smallint not null,
        primary key (id)
    );

    create table Connector (
        id varchar(32) not null,
        name varchar(255) not null,
        removed smallint not null,
        enabled smallint not null,
        licenseKey varchar(255) not null,
        tag varchar(255) not null,
        tokenConnector_id varchar(32),
        licenseBundle_id varchar(32),
        loginService_id varchar(32),
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
        removed smallint not null,
        activationDate timestamp,
        brand varchar(255),
        carrier varchar(255),
        email varchar(255),
        model varchar(255),
        pin varchar(255),
        licenseBundle_id varchar(32),
        primary key (id)
    );

    create table LicenseBundle (
        id varchar(32) not null,
        name varchar(255) not null,
        removed smallint not null,
        enabled smallint not null,
        period integer not null,
        licenseBundleType_id varchar(32),
        primary key (id)
    );

    create table LicenseBundleType (
        id varchar(32) not null,
        name varchar(255) not null,
        removed smallint not null,
        primary key (id)
    );

    create table Operation (
        id varchar(32) not null,
        name varchar(255) not null,
        removed smallint not null,
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
        add constraint FKF24106EFC144AB30 
        foreign key (id) 
        references BaseLoginService;

    alter table Connector 
        add constraint FK54EC142D12B51C7B 
        foreign key (tokenConnector_id) 
        references Connector;

    alter table Connector 
        add constraint FK54EC142D4B0B5123 
        foreign key (loginService_id) 
        references BaseLoginService;

    alter table Connector 
        add constraint FK54EC142D37BD6462 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table Connector_Operation 
        add constraint FKA9E46FB58FFA9002 
        foreign key (Connector_id) 
        references Connector;

    alter table Connector_Operation 
        add constraint FKA9E46FB5A82EF51D 
        foreign key (operations_id) 
        references Operation;

    alter table LicenseActivation 
        add constraint FKF36D841737BD6462 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table LicenseBundle 
        add constraint FKA1D5DC03B014242 
        foreign key (licenseBundleType_id) 
        references LicenseBundleType;

    alter table StaticConnector 
        add constraint FK35E7595F1D049ED0 
        foreign key (id) 
        references Connector;

    alter table StaticOperation 
        add constraint FKBB883A79A2A57FEA 
        foreign key (id) 
        references Operation;

    alter table StaticOperation 
        add constraint FKBB883A796F0928A2 
        foreign key (staticConnector_id) 
        references StaticConnector;
