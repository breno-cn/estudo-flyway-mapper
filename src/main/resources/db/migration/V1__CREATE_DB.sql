CREATE TABLE hello_entity (
    id INT NOT NULL,
    prefix VARCHAR(128),
    name VARCHAR(128),

    PRIMARY KEY (id)
);

INSERT INTO hello_entity(id, prefix, name) VALUES (1, 'Hello', 'Breno');
