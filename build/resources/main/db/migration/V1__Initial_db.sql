CREATE SCHEMA IF NOT EXISTS public;
CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     login VARCHAR(50) NOT NULL,
                                     password VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS entities (
                                        id SERIAL PRIMARY KEY,
                                        user_id INTEGER NOT NULL,
                                        name VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

INSERT INTO users (login, password)
VALUES ('first', '$2a$12$WjTQz8w/OP02JLBnLOQJ5umKG/7BdsCchWxy1nqtdyzW4lLGqtSKG'),
       ('second', '$2a$12$WjTQz8w/OP02JLBnLOQJ5umKG/7BdsCchWxy1nqtdyzW4lLGqtSKG'),
       ('third', '$2a$12$WjTQz8w/OP02JLBnLOQJ5umKG/7BdsCchWxy1nqtdyzW4lLGqtSKG');

INSERT INTO entities (user_id, name)
VALUES ((SELECT id FROM users
         WHERE login = 'first'), 'firstUserEntity0'),
       ((SELECT id FROM users
         WHERE login = 'first'), 'firstUserEntity1'),
       ((SELECT id FROM users
         WHERE login = 'first'), 'firstUserEntity2'),
       ((SELECT id FROM users
         WHERE login = 'second'), 'secondUserEntity0'),
       ((SELECT id FROM users
         WHERE login = 'second'), 'secondUserEntity1');
