DROP TABLE IF EXISTS address;
CREATE TABLE address (
    street VARCHAR(100) NOT NULL,
    number VARCHAR(5) NOT NULL,

    CONSTRAINT pk_address PRIMARY KEY(street, number)
);

DROP TABLE IF EXISTS locality;
CREATE TABLE locality (
    postal_code VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL,
    address_street VARCHAR(100) NOT NULL,
    address_number VARCHAR(5) NOT NULL,

    CONSTRAINT pk_localite PRIMARY KEY(postal_code, city),
    CONSTRAINT fk_localite FOREIGN KEY(address_street, address_number) REFERENCES address(street, number)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender VARCHAR(10),
    locality_postal_code VARCHAR(10) NOT NULL,
    locality_city VARCHAR(50) NOT NULL,

    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    enabled BOOLEAN NOT NULL,

    CONSTRAINT user_fk FOREIGN KEY (locality_postal_code, locality_city) REFERENCES locality(postal_code, city)
);

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
    id SERIAL PRIMARY KEY,
    label VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,

    CONSTRAINT authority_fk FOREIGN KEY (username) REFERENCES user(username),
    CONSTRAINT authority_unique UNIQUE(label, username)

);

DROP TABLE IF EXISTS order;
CREATE TABLE order (
    id SERIAL PRIMARY KEY,
    creation_date DATE NOT NULL,
    payment_state_label VARCHAR(15) NOT NULL,
    user_id SERIAL NOT NULL,

    CONSTRAINT order_user_fk FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT order_state_fk FOREIGN KEY (payment_state_label) REFERENCES payment_state(label_fr)
);

DROP TABLE IF EXISTS payment_state;
CREATE TABLE payment_state (
    label_fr VARCHAR(15) PRIMARY KEY,
    label_en VARCHAR(15) NOT NULL
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    label_fr VARCHAR(20) NOT NULL,
    label_en VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name_fr VARCHAR(50) NOT NULL,
    name_en VARCHAR(50) NOT NULL,
    quantityStock NUMERIC NOT NULL,
    unitary_price NUMERIC(10, 2) NOT NULL,
    category_id SERIAL NOT NULL,

    CONSTRAINT product_fk FOREIGN KEY (category_id) REFERENCES category(id)
);

DROP TABLE IF EXISTS order_line;
CREATE TABLE order_line (
    quantity NUMERIC NOT NULL,
    order_id SERIAL NOT NULL,
    product_id SERIAL NOT NULL,

    CONSTRAINT order_line_pk PRIMARY KEY(order_id, product_id),
    CONSTRAINT order_line_order_fk FOREIGN KEY (order_id) REFERENCES order(id),
    CONSTRAINT order_line_product_fk FOREIGN KEY (product_id) REFERENCES product(id)
);