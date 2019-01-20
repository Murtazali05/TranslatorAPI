
CREATE TABLE translation
(
    id serial PRIMARY KEY NOT NULL,
    calltime timestamp NOT NULL,
    input varchar(255) NOT NULL,
    output varchar(255) NOT NULL
);