create table product_attribute(
    p_id INT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL,
    version INT,
    PRIMARY KEY(p_id, company_id)
);

create table sku_attribute(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    sku_id BIGINT NOT NULL,
    attribute_id INT NOT NULL,
    company_id BIGINT NOT NULL,
    UNIQUE KEY(sku_id, attribute_id, company_id)
);