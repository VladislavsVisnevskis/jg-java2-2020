CREATE TABLE shopping_cart(
id BIGINT AUTO_INCREMENT NOT NULL,
name VARCHAR(40),
PRIMARY KEY(id));

CREATE TABLE shopping_cart_product(
shopping_cart_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
PRIMARY KEY (shopping_cart_id, product_id),
FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id),
FOREIGN KEY (product_id) REFERENCES product(id)
);
