
    alter table AdAuthContainer 
        drop constraint FK33385836CE68831D;

    alter table Application 
        drop constraint FKC00DAD30F937C543;

    alter table Application_Connector 
        drop constraint FK47A7FFDEC7F3B843;

    alter table Application_Connector 
        drop constraint FK47A7FFDECB9F494A;

    alter table Application_PushServer 
        drop constraint FK3A11F58CC7F3B843;

    alter table Application_PushServer 
        drop constraint FK3A11F58C3B7BB6A8;

    alter table Connector 
        drop constraint FK54EC142DC7F3B843;

    alter table Connector 
        drop constraint FK54EC142DD57D15DC;

    alter table Connector 
        drop constraint FK54EC142DF937C543;

    alter table Connector 
        drop constraint FK54EC142D15566143;

    alter table DataSourceConnector 
        drop constraint FKEC68A148DFCC9831;

    alter table DataSourceQueryOperation 
        drop constraint FKA0A67564656D794B;

    alter table EjbConnector 
        drop constraint FK929CF890DFCC9831;

    alter table LicenseActivation 
        drop constraint FKF36D8417F937C543;

    alter table LicenseBundle 
        drop constraint FKA1D5DC03D4AE4AA3;

    alter table Operation 
        drop constraint FKDA8CF54752C28963;

    alter table Operation 
        drop constraint FKDA8CF547F937C543;

    alter table ProxyConnector 
        drop constraint FKB884F19FDFCC9831;

    alter table PushServer 
        drop constraint FKD5506B1DC7F3B843;

    alter table SapConnector 
        drop constraint FK1E4DEAABDFCC9831;

    alter table SapFunctionOperation 
        drop constraint FKBE850CCD656D794B;

    alter table SapFunctionOperation_SapInputParameter 
        drop constraint FK82C5306F405BEE84;

    alter table SapFunctionOperation_SapInputParameter 
        drop constraint FK82C5306FB85F0FF1;

    alter table SapFunctionOperation_SapInputTable 
        drop constraint FKAC700B941DABC1CE;

    alter table SapFunctionOperation_SapInputTable 
        drop constraint FKAC700B94B85F0FF1;

    alter table SapFunctionOperation_SapOutputParameter 
        drop constraint FK519CE838880E1EAD;

    alter table SapFunctionOperation_SapOutputParameter 
        drop constraint FK519CE838B85F0FF1;

    alter table SapFunctionOperation_SapOutputTable 
        drop constraint FKC1650FDD41466E77;

    alter table SapFunctionOperation_SapOutputTable 
        drop constraint FKC1650FDDB85F0FF1;

    alter table SapRow_SapParameter 
        drop constraint FKE0BC702EC6A36471;

    alter table SapRow_SapParameter 
        drop constraint FKE0BC702E9E2F1381;

    alter table SapTable_SapRow 
        drop constraint FK42E1D12B737C4E31;

    alter table SapTable_SapRow 
        drop constraint FK42E1D12B921FDF8E;

    alter table SapTable_SapTableField 
        drop constraint FK7F55E15B737C4E31;

    alter table SapTable_SapTableField 
        drop constraint FK7F55E15B7AE85203;

    alter table StaticConnector 
        drop constraint FK35E7595FDFCC9831;

    alter table StaticOperation 
        drop constraint FKBB883A79656D794B;

    alter table WebServiceConnector 
        drop constraint FKE0B4B86CDFCC9831;

    drop table AdAuthContainer;

    drop table Application;

    drop table Application_Connector;

    drop table Application_PushServer;

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

    drop table PushServer;

    drop table SapConnector;

    drop table SapFunctionOperation;

    drop table SapFunctionOperation_SapInputParameter;

    drop table SapFunctionOperation_SapInputTable;

    drop table SapFunctionOperation_SapOutputParameter;

    drop table SapFunctionOperation_SapOutputTable;

    drop table SapParameter;

    drop table SapRow;

    drop table SapRow_SapParameter;

    drop table SapTable;

    drop table SapTableField;

    drop table SapTable_SapRow;

    drop table SapTable_SapTableField;

    drop table StaticConnector;

    drop table StaticOperation;

    drop table WebServiceConnector;

    create table AdAuthContainer (
        id varchar(32) not null,
        dnsResolving tinyint null,
        domainName varchar(255) null,
        domainUser varchar(255) null,
        domainUserPassword varchar(255) null,
        groupAttribute varchar(255) null,
        groupFilter varchar(255) null,
        ip varchar(255) null,
        searchBase varchar(255) null,
        searchFilter varchar(255) null,
        url varchar(255) null,
        primary key (id)
    );

    create table Application (
        id varchar(32) not null,
        name varchar(255) not null,
        enabled tinyint null,
        licenseKey varchar(255) null,
        licenseBundle_id varchar(32) null,
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
        enabled tinyint not null,
        licenseKey varchar(255) not null,
        tag varchar(255) not null unique,
        licenseBundle_id varchar(32) null,
        tokenConnector_id varchar(32) null,
        authContainer_id varchar(32) null,
        application_id varchar(32) null,
        primary key (id)
    );

    create table DataSourceConnector (
        id varchar(32) not null,
        dataSource varchar(255) null,
        primary key (id)
    );

    create table DataSourceQueryOperation (
        id varchar(32) not null,
        query varchar(5000) null,
        returnResultSet tinyint null,
        primary key (id)
    );

    create table EjbConnector (
        id varchar(32) not null,
        ejbName varchar(255) null,
        primary key (id)
    );

    create table LicenseActivation (
        id varchar(32) not null,
        name varchar(255) not null,
        activationDate datetime null,
        brand varchar(255) null,
        carrier varchar(255) null,
        email varchar(255) null,
        licenseKey varchar(255) null,
        model varchar(255) null,
        pin varchar(255) null,
        licenseBundle_id varchar(32) null,
        primary key (id)
    );

    create table LicenseBundle (
        id varchar(32) not null,
        name varchar(255) not null,
        enabled tinyint not null,
        period int not null,
        licenseBundleType_id varchar(32) null,
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
        licenseKey varchar(255) null,
        tag varchar(255) null unique,
        licenseBundle_id varchar(32) null,
        connector_id varchar(32) null,
        primary key (id),
        unique (id, tag)
    );

    create table ProxyConnector (
        id varchar(32) not null,
        url varchar(255) null,
        primary key (id)
    );

    create table PushServer (
        id varchar(32) not null,
        name varchar(255) not null,
        port varchar(255) not null,
        tag varchar(255) not null unique,
        url varchar(255) not null,
        application_id varchar(32) null,
        primary key (id)
    );

    create table SapConnector (
        id varchar(32) not null,
        asHost varchar(255) not null,
        client varchar(255) not null,
        lang varchar(255) null,
        router varchar(255) null,
        sysnr varchar(255) not null,
        primary key (id)
    );

    create table SapFunctionOperation (
        id varchar(32) not null,
        functionName varchar(255) null,
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
        list varchar(255) null,
        message varchar(255) null,
        object varchar(255) null,
        resultCode int null,
        token varchar(255) null,
        primary key (id)
    );

    create table WebServiceConnector (
        id varchar(32) not null,
        wsdl varchar(255) null,
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
        add constraint FK54EC142DC7F3B843 
        foreign key (application_id) 
        references Application;

    alter table Connector 
        add constraint FK54EC142DD57D15DC 
        foreign key (tokenConnector_id) 
        references Connector;

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
