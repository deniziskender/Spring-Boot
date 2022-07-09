DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(250)   NOT NULL,
    description VARCHAR(250)   NOT NULL,
    price       DECIMAL(20, 2) NOT NULL,
    status      INT            NOT NULL
);