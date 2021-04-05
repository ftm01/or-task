DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL,
    name VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO users (name, password) VALUES ('superadmin', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
INSERT INTO users (name, password) VALUES ('admin', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
INSERT INTO users (name, password) VALUES ('moderator', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
INSERT INTO users (name, password) VALUES ('user', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
