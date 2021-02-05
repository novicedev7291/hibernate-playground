package com.example.model.product.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(staticName = "of")
@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = PRIVATE)
class ProductAttributeId implements Serializable {
    private static final long serialVersionUID = 235409241789720275L;
    @Column(name = "p_id")
    private Integer attributeId;
    @Column(name = "company_id")
    private Long companyId;

    public static ProductAttributeId of(Long companyId) {
        ProductAttributeId id = new ProductAttributeId();
        id.companyId = companyId;
        return id;
    }
}
