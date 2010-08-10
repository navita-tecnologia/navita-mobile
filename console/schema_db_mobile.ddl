
    alter table AdAuthContainer 
        drop constraint FK3338583622670B60;

    alter table Connector 
        drop constraint FK54EC142DA338379F;

    alter table Connector 
        drop constraint FK54EC142D4D364D86;

    alter table Connector 
        drop constraint FK54EC142D6954E986;

    alter table DataSourceConnector 
        drop constraint FKEC68A148AD87B9F4;

    alter table DataSourceQueryOperation 
        drop constraint FKA0A6756433289B0E;

    alter table EjbConnector 
        drop constraint FK929CF890AD87B9F4;

    alter table LicenseActivation 
        drop constraint FKF36D84174D364D86;

    alter table LicenseBundle 
        drop constraint FKA1D5DC0379D8F966;

    alter table Operation 
        drop constraint FKDA8CF547207DAB26;

    alter table Operation 
        drop constraint FKDA8CF5474D364D86;

    alter table ProxyConnector 
        drop constraint FKB884F19FAD87B9F4;

    alter table SapConnector 
        drop constraint FK1E4DEAABAD87B9F4;

    alter table SapFunctionOperation 
        drop constraint FKBE850CCD33289B0E;

    alter table SapFunctionOperation_SapInputParameter 
        drop constraint FK82C5306F6419D1E1;

    alter table SapFunctionOperation_SapInputParameter 
        drop constraint FK82C5306F5A66464E;

    alter table SapFunctionOperation_SapInputTable 
        drop constraint FKAC700B94B8F3DBAB;

    alter table SapFunctionOperation_SapInputTable 
        drop constraint FKAC700B945A66464E;

    alter table SapFunctionOperation_SapOutputParameter 
        drop constraint FK519CE838ABCC020A;

    alter table SapFunctionOperation_SapOutputParameter 
        drop constraint FK519CE8385A66464E;

    alter table SapFunctionOperation_SapOutputTable 
        drop constraint FKC1650FDDDC8E8854;

    alter table SapFunctionOperation_SapOutputTable 
        drop constraint FKC1650FDD5A66464E;

    alter table SapParameter 
        drop constraint FKB552AA07F9F2518E;

    alter table SapParameter 
        drop constraint FKB552AA075A66464E;

    alter table SapRow 
        drop constraint FK932D4EB8EC4680E;

    alter table SapTable 
        drop constraint FK7D2A112C5A66464E;

    alter table StaticConnector 
        drop constraint FK35E7595FAD87B9F4;

    alter table StaticOperation 
        drop constraint FKBB883A7933289B0E;

    alter table WebServiceConnector 
        drop constraint FKE0B4B86CAD87B9F4;

    drop table AdAuthContainer;

    drop table AuthContainer;

    drop table Connector;

    drop table DataSourceConnector;

    drop table DataSourceQueryOperation;

    drop table EjbConnector;

    drop table LicenseActivation;

    drop table LicenseBundle;

    drop table LicenseBundleType;

    drop table Operation;

    drop table ProxyConnector;

    drop table SapConnector;

    drop table SapFunctionOperation;

    drop table SapFunctionOperation_SapInputParameter;

    drop table SapFunctionOperation_SapInputTable;

    drop table SapFunctionOperation_SapOutputParameter;

    drop table SapFunctionOperation_SapOutputTable;

    drop table SapParameter;

    drop table SapRow;

    drop table SapTable;

    drop table StaticConnector;

    drop table StaticOperation;

    drop table WebServiceConnector;

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
        tag varchar(255) not null,
        tokenConnector_id varchar(32),
        authContainer_id varchar(32),
        licenseBundle_id varchar(32),
        primary key (id)
    );

    create table DataSourceConnector (
        id varchar(32) not null,
        dataSource varchar(255),
        primary key (id)
    );

    create table DataSourceQueryOperation (
        id varchar(32) not null,
        query varchar(255),
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
        connector_id varchar(32),
        licenseBundle_id varchar(32),
        primary key (id)
    );

    create table ProxyConnector (
        id varchar(32) not null,
        url varchar(255),
        primary key (id)
    );

    create table SapConnector (
        id varchar(32) not null,
        client varchar(255) not null,
        ip varchar(255) not null,
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
        parameterName varchar(255),
        parameterValue varchar(255),
        sapFunctionOperation_id varchar(32),
        sapRow_id varchar(32),
        primary key (id)
    );

    create table SapRow (
        id varchar(32) not null,
        name varchar(255) not null,
        sapTable_id varchar(32),
        primary key (id)
    );

    create table SapTable (
        id varchar(32) not null,
        name varchar(255) not null,
        tableName varchar(255),
        sapFunctionOperation_id varchar(32),
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
        primary key (id)
    );

    create table WebServiceConnector (
        id varchar(32) not null,
        wsdl varchar(255),
        primary key (id)
    );

    alter table AdAuthContainer 
        add constraint FK3338583622670B60 
        foreign key (id) 
        references AuthContainer;

    alter table Connector 
        add constraint FK54EC142DA338379F 
        foreign key (tokenConnector_id) 
        references Connector;

    alter table Connector 
        add constraint FK54EC142D4D364D86 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table Connector 
        add constraint FK54EC142D6954E986 
        foreign key (authContainer_id) 
        references AuthContainer;

    alter table DataSourceConnector 
        add constraint FKEC68A148AD87B9F4 
        foreign key (id) 
        references Connector;

    alter table DataSourceQueryOperation 
        add constraint FKA0A6756433289B0E 
        foreign key (id) 
        references Operation;

    alter table EjbConnector 
        add constraint FK929CF890AD87B9F4 
        foreign key (id) 
        references Connector;

    alter table LicenseActivation 
        add constraint FKF36D84174D364D86 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table LicenseBundle 
        add constraint FKA1D5DC0379D8F966 
        foreign key (licenseBundleType_id) 
        references LicenseBundleType;

    alter table Operation 
        add constraint FKDA8CF547207DAB26 
        foreign key (connector_id) 
        references Connector;

    alter table Operation 
        add constraint FKDA8CF5474D364D86 
        foreign key (licenseBundle_id) 
        references LicenseBundle;

    alter table ProxyConnector 
        add constraint FKB884F19FAD87B9F4 
        foreign key (id) 
        references Connector;

    alter table SapConnector 
        add constraint FK1E4DEAABAD87B9F4 
        foreign key (id) 
        references Connector;

    alter table SapFunctionOperation 
        add constraint FKBE850CCD33289B0E 
        foreign key (id) 
        references Operation;

    alter table SapFunctionOperation_SapInputParameter 
        add constraint FK82C5306F6419D1E1 
        foreign key (inputParameters_id) 
        references SapParameter;

    alter table SapFunctionOperation_SapInputParameter 
        add constraint FK82C5306F5A66464E 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapFunctionOperation_SapInputTable 
        add constraint FKAC700B94B8F3DBAB 
        foreign key (inputTables_id) 
        references SapTable;

    alter table SapFunctionOperation_SapInputTable 
        add constraint FKAC700B945A66464E 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapFunctionOperation_SapOutputParameter 
        add constraint FK519CE838ABCC020A 
        foreign key (outputParameters_id) 
        references SapParameter;

    alter table SapFunctionOperation_SapOutputParameter 
        add constraint FK519CE8385A66464E 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapFunctionOperation_SapOutputTable 
        add constraint FKC1650FDDDC8E8854 
        foreign key (outputTables_id) 
        references SapTable;

    alter table SapFunctionOperation_SapOutputTable 
        add constraint FKC1650FDD5A66464E 
        foreign key (SapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapParameter 
        add constraint FKB552AA07F9F2518E 
        foreign key (sapRow_id) 
        references SapRow;

    alter table SapParameter 
        add constraint FKB552AA075A66464E 
        foreign key (sapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table SapRow 
        add constraint FK932D4EB8EC4680E 
        foreign key (sapTable_id) 
        references SapTable;

    alter table SapTable 
        add constraint FK7D2A112C5A66464E 
        foreign key (sapFunctionOperation_id) 
        references SapFunctionOperation;

    alter table StaticConnector 
        add constraint FK35E7595FAD87B9F4 
        foreign key (id) 
        references Connector;

    alter table StaticOperation 
        add constraint FKBB883A7933289B0E 
        foreign key (id) 
        references Operation;

    alter table WebServiceConnector 
        add constraint FKE0B4B86CAD87B9F4 
        foreign key (id) 
        references Connector;
