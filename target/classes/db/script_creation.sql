CREATE SCHEMA IF NOT EXISTS anishopdb;

DROP TABLE IF EXISTS anishopdb.order_line CASCADE;
DROP TABLE IF EXISTS anishopdb.product CASCADE;
DROP TABLE IF EXISTS anishopdb.category CASCADE;
DROP TABLE IF EXISTS anishopdb."order" CASCADE;
DROP TABLE IF EXISTS anishopdb.payment_state CASCADE;
DROP TABLE IF EXISTS anishopdb.authority CASCADE;
DROP TABLE IF EXISTS anishopdb."user" CASCADE;
DROP TABLE IF EXISTS anishopdb.address CASCADE;
DROP TABLE IF EXISTS anishopdb.locality CASCADE;

CREATE TABLE anishopdb.locality (
    postal_code VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL,

    CONSTRAINT pk_localite PRIMARY KEY(postal_code, city)
);

CREATE TABLE anishopdb.address (
    street VARCHAR(100) NOT NULL,
    number VARCHAR(5) NOT NULL,
    locality_postal_code VARCHAR(10) NOT NULL,
    locality_city VARCHAR(50) NOT NULL,

    CONSTRAINT pk_address PRIMARY KEY(street, number, locality_postal_code, locality_city),
    CONSTRAINT fk_address FOREIGN KEY(locality_postal_code, locality_city) REFERENCES anishopdb.locality(postal_code, city)
);

CREATE TABLE anishopdb."user" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender VARCHAR(20),
    address_street VARCHAR(100) NOT NULL,
    address_number VARCHAR(5) NOT NULL,
    address_locality_postal_code VARCHAR(10) NOT NULL,
    address_locality_city VARCHAR(50) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    enabled BOOLEAN NOT NULL,

    CONSTRAINT user_fk FOREIGN KEY (address_street, address_number, address_locality_postal_code, address_locality_city)
        REFERENCES anishopdb.address(street, number, locality_postal_code, locality_city)
);

CREATE TABLE anishopdb.authority (
    id SERIAL PRIMARY KEY,
    label VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,

    CONSTRAINT authority_fk FOREIGN KEY (username)
        REFERENCES anishopdb."user"(username),
    CONSTRAINT authority_unique UNIQUE(label, username)
);

CREATE TABLE anishopdb.payment_state (
    label_fr VARCHAR(15) PRIMARY KEY,
    label_en VARCHAR(15) NOT NULL
);

CREATE TABLE anishopdb."order" (
    id SERIAL PRIMARY KEY,
    creation_date DATE NOT NULL,
    payment_state_label VARCHAR(15) NOT NULL,
    user_id INTEGER NOT NULL,

    CONSTRAINT order_user_fk FOREIGN KEY (user_id)
        REFERENCES anishopdb."user"(id),
    CONSTRAINT order_state_fk FOREIGN KEY (payment_state_label)
        REFERENCES anishopdb.payment_state(label_fr)
);

CREATE TABLE anishopdb.category (
    id SERIAL PRIMARY KEY,
    label_fr VARCHAR(20) NOT NULL,
    label_en VARCHAR(20) NOT NULL
);

CREATE TABLE anishopdb.product (
    id SERIAL PRIMARY KEY,
    name_fr VARCHAR(50) NOT NULL,
    name_en VARCHAR(50) NOT NULL,
    quantityStock NUMERIC NOT NULL,
    unitary_price NUMERIC(10, 2) NOT NULL,
    category_id INTEGER NOT NULL,

    CONSTRAINT product_fk FOREIGN KEY (category_id)
        REFERENCES anishopdb.category(id)
);

CREATE TABLE anishopdb.order_line (
    quantity NUMERIC NOT NULL,
    order_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,

    CONSTRAINT order_line_pk PRIMARY KEY(order_id, product_id),
    CONSTRAINT order_line_order_fk FOREIGN KEY (order_id)
        REFERENCES anishopdb."order"(id),
    CONSTRAINT order_line_product_fk FOREIGN KEY (product_id)
        REFERENCES anishopdb.product(id)
);