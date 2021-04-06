DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL,
    name VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO users (name, password) VALUES ('Philipp', 'test');
INSERT INTO users (name, password) VALUES ('Naura', 'test');
INSERT INTO users (name, password) VALUES ('Bujar', 'test');
INSERT INTO users (name, password) VALUES ('Nora', 'test');
INSERT INTO users (name, password) VALUES ('Armend', 'test');
