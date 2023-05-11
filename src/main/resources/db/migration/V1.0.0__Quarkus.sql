CREATE TABLE USERS (
                       id bigserial not null primary key,
                       name VARCHAR not null,
                       email VARCHAR not null UNIQUE,
                       cellphone_number VARCHAR not null
);

CREATE TABLE INGREDIENTS (
                       id bigserial not null primary key,
                       name VARCHAR not null,
                       quantity_in_kg DECIMAL not null
);
