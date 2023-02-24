create table SALES_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ADDRESS_CITY varchar(100),
    ADDRESS_STREET varchar(150),
    ADDRESS_NUMBER_ varchar(10),
    --
    NAME varchar(100) not null,
    EMAIL varchar(50),
    CUSTOMER_TYPE integer,
    --
    primary key (ID)
);