CREATE SCHEMA IF NOT EXISTS USER1;

CREATE TABLE USER1.client_data (
                                   id SERIAL PRIMARY KEY,
                                   name VARCHAR(255) NOT NULL,
                                   surname VARCHAR(225) NOT NULL,
                                   age INT NOT NULL,
                                   phone_number VARCHAR(16)
);

INSERT INTO USER1.client_data (id, name, surname, age, phone_number)
VALUES
    (1, 'Дмитрий', 'Конев', 20, '89241568237'),
    (2, 'Alexey', 'Иванов', 22, '89432876537'),
    (5, 'Иван', 'Сергеев', 38, '83465528462');

CREATE TABLE USER1.ORDERS (
                              id INT PRIMARY KEY,
                              date TIMESTAMP,
                              customer_id INT NOT NULL,
                              product_name VARCHAR(255) NOT NULL,
                              amount INTEGER NOT NULL,
                              FOREIGN KEY (customer_id) REFERENCES USER1.client_data(id)
);

INSERT INTO USER1.ORDERS (id, date, customer_id, product_name, amount)
VALUES
    (1, '2024-10-12', 2, 'cigarettes', 200),
    (5, '2024-10-01', 1, 'bred', 150),
    (2, '2024-09-12', 5, 'meat', 270);




