package com.example.model.product.attribute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "product_attribute")
@Getter
@NoArgsConstructor(access = PRIVATE)
@SQLInsert(sql = "insert into product_attribute(name,company_id,version) values(?, ?, ?)")
class ProductAttribute implements Serializable {
    private static final long serialVersionUID = -5601296300158482106L;
    @EmbeddedId
    private ProductAttributeId productAttributeId;

    private String name;

    @Version
    @Column(insertable = false)
    private Integer version;

    public static ProductAttribute of(ProductAttributeId id, String name) {
        ProductAttribute attribute = new ProductAttribute();
        attribute.productAttributeId = id;
        attribute.name = name;
        return attribute;
    }
}
