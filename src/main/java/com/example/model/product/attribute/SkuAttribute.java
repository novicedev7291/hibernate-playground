package com.example.model.product.attribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@Entity
@Table(name = "sku_attribute")
@Getter
@NoArgsConstructor(access = PRIVATE)
class SkuAttribute implements Serializable {
    private static final long serialVersionUID = 1447434720676929902L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long skuId;
    @Embedded
    private ProductAttributeId attributeId;

    public static SkuAttribute of(Long skuId, ProductAttributeId attributeId) {
        return new SkuAttribute(null, skuId, attributeId);
    }
}
