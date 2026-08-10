# Utilisateur

CREATE TABLE user (
    id NUMERIC PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender VARCHAR(10),

    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authority (
    id NUMERIC PRIMARY KEY AUTO_INCREMENT,
    label VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,

    CONSTRAINT authority_fk FOREIGN KEY (username) REFERENCES user(username),
    CONSTRAINT authority_unique UNIQUE(label, username)

);

CREATE TABLE address (
    street VARCHAR(100) NOT NULL,
    number VARCHAR(5) NOT NULL,

    CONSTRAINT pk_address PRIMARY KEY(street, number)
);

CREATE TABLE locality (
    postal_code VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL,
    address_street VARCHAR(100) NOT NULL,
    address_number VARCHAR(5) NOT NULL,

    CONSTRAINT pk_localite PRIMARY KEY(postal_code, city),
    CONSTRAINT fk_localite FOREIGN KEY(address_street, address_number) REFERENCES address(street, number)
);

CREATE TABLE order (
    id NUMERIC PRIMARY KEY AUTO_INCREMENT,
    creation_date DATE NOT NULL,
    state_label VARCHAR(10) NOT NULL,
    user_id NUMERIC NOT NULL,

    CONSTRAINT order_user_fk FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT order_state_fk FOREIGN KEY (state_label) REFERENCES state(label)
);

CREATE TABLE state (
    label VARCHAR(15) PRIMARY KEY
);

CREATE TABLE order_line (
    quantity NUMERIC NOT NULL,
    order_id NUMERIC NOT NULL,
    product_id NUMERIC NOT NULL,

    CONSTRAINT order_line_order_fk FOREIGN KEY (order_id) REFERENCES order(id),
    CONSTRAINT order_line_product_fk FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE product (
    id NUMERIC PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    quantityStock NUMERIC NOT NULL,
    unitary_price FLOAT(100, 2) NOT NULL,
    category_id NUMERIC NOT NULL,

    CONSTRAINT product_fk FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE category (
    id NUMERIC PRIMARY KEY AUTO_INCREMENT,
    label VARCHAR(20) NOT NULL
)


