DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL,
    name VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO users (name, password) VALUES ('Philipp', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
INSERT INTO users (name, password) VALUES ('Naura', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
INSERT INTO users (name, password) VALUES ('Bujar', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
INSERT INTO users (name, password) VALUES ('Nora', '$2a$10$8lkWgZGRfUiGNOTaKqEuZuIwB9LcC70rc7fs.sshdPbn7N96Ac0S.');
