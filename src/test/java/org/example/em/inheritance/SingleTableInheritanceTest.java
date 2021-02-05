package org.example.em.inheritance;

import com.example.model.ExportOrder;
import com.example.model.RetailOrder;
import com.sun.org.apache.regexp.internal.RE;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class SingleTableInheritanceTest extends EntityManagerTest {
 @Test
    void shouldPersistRetailOrderAndExportOrderInSameTable() {
     doInTransaction( em -> {
         ExportOrder e = new ExportOrder();
         e.setId(1);
         e.setCustomerName("XYZ Pvt. Ltd");
         e.setTotal(new BigDecimal("1020.92"));
         e.setConsignee("ABC Pvt. Ltd.");
         e.setShipper("PQRS Pvt. Ltd.");

         RetailOrder r = new RetailOrder();
         r.setId(2);
         r.setCustomerName("Kuldeep Yadav");
         r.setTotal(new BigDecimal("201.12"));
         r.setIsPaid(true);

         em.persist(r);
         em.persist(e);
     });
 }
}
