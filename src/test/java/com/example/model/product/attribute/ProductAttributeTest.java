package com.example.model.product.attribute;

import org.example.em.EntityManagerTest;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductAttributeTest extends EntityManagerTest {
    @Test
    void shouldSaveAllEntities() {

        doInTransaction(em -> {
            ProductAttributeId attributeId = ProductAttributeId.of(10L);
            ProductAttribute attribute = ProductAttribute.of(attributeId, "Contains Alcohol");

            em.persist(attribute);
        });

        doInTransaction(em -> {
            ProductAttributeId attributeId = ProductAttributeId.of(1, 10L);
            ProductAttribute attribute = em.find(ProductAttribute.class, attributeId);

            assertNotNull(attribute);

            SkuAttribute skuAttribute = SkuAttribute.of(10L, attribute.getProductAttributeId());

            em.persist(skuAttribute);
        });

        doInTransaction(em -> {
            ProductAttributeId attributeId = ProductAttributeId.of(1, 10L);

            Session session = em.unwrap(Session.class);

            final SkuAttribute skuAttribute = (SkuAttribute) session.createQuery("Select s from SkuAttribute s where s.productAttributeId.id = :value and s.productAttributeId.companyId = :companyId and s.skuId = :skuId")
                                                                    .setParameter("value", attributeId.getAttributeId())
                                                                    .setParameter("companyId", attributeId.getCompanyId())
                                                                    .setParameter("skuId", 10L).uniqueResult();

            assertNotNull(skuAttribute);

        });
    }
}
