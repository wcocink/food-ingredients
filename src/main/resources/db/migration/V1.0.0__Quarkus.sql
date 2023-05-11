CREATE TABLE USERS (
                       id bigserial not null,
                       name VARCHAR not null,
                       email VARCHAR not null,
                       cellphone_number VARCHAR not null,
                       primary key (id, email)
);
INSERT INTO USERS(name, email, cellphone_number)
VALUES ('Willian', 'test@test.com', '1234556789');

CREATE TABLE INGREDIENTS (
                       id bigserial not null primary key,
                       name VARCHAR not null,
                       quantity_in_kg DECIMAL not null
);
INSERT INTO INGREDIENTS(name, quantity_in_kg)
VALUES ('Sal', 0.5);