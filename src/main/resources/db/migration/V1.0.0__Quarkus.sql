CREATE TABLE USERS (
                       id bigserial not null primary key,
                       name VARCHAR not null,
                       email VARCHAR not null,
                       cellphone_number VARCHAR not null
);
INSERT INTO users(name, email, cellphone_number)
VALUES ('Willian', 'test@test.com', '1234556789');
