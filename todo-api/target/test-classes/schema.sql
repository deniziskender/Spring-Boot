DROP TABLE IF EXISTS todo;

CREATE TABLE todo
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    explanation VARCHAR(500) NOT NULL
);