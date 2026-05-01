CREATE TABLE clothes (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    name VARCHAR(100),
    size VARCHAR(10),
    color VARCHAR(20),
    price DOUBLE PRECISION,
    brand VARCHAR(50),
    quantity INT
);