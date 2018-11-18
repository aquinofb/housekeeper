CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE sections (
    id    uuid DEFAULT uuid_generate_v4 (),
    name  VARCHAR NOT NULL,
    order INTEGER DEFAULT 0,
    PRIMARY KEY (id)
);

ALTER TABLE sections ADD CONSTRAINT sections_unique_name UNIQUE (name);

CREATE TABLE orders (
    id          uuid DEFAULT uuid_generate_v4 (),
    created_at  TIMESTAMP NOT NULL,
    section_id  uuid REFERENCES sections,
    PRIMARY KEY (id)
);

CREATE TABLE categories (
    id    uuid DEFAULT uuid_generate_v4 (),
    name  VARCHAR NOT NULL
);

ALTER TABLE categories ADD CONSTRAINT categories_unique_name UNIQUE (name);

CREATE TABLE products (
    id    uuid DEFAULT uuid_generate_v4 (),
    name  VARCHAR NOT NULL,
    default_size INTEGER NOT NULL,
    default_unit_of_volume VARCHAR(2) NOT NULL,
    category_id uuid REFERENCES categories
);

CREATE TABLE items (
    id          uuid DEFAULT uuid_generate_v4 (),
    quantity    INTEGER NOT NULL,
    size        INTEGER NOT NULL,
    unit_of_volume  VARCHAR(2) NOT NULL,
    order_id    uuid REFERENCES orders,
    product_id  uuid REFERENCES products
);
