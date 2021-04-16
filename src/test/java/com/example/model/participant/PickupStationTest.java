package com.example.model.participant;

import com.example.model.participants.PickupStation;
import com.example.model.participants.Vendor;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class PickupStationTest extends EntityManagerTest {
    @Test
    void shouldAddBothVendorAndStation() {
        final UUID vendorId = UUID.randomUUID();
        doInTransaction(em -> {
            Vendor vendor = new Vendor(vendorId);

            PickupStation station1 = new PickupStation(1L);
            PickupStation station2 = new PickupStation(2L);

            vendor.add(station1);
            vendor.add(station2);

            em.persist(vendor);
        });

        doInTransaction(em -> {
            Vendor vendor = em.find(Vendor.class, vendorId);

            Assertions.assertNotNull(vendor);
            Assertions.assertNotNull(vendor.getStations());

            Assertions.assertEquals(vendor.getStations().size(), 2);
        });
    }
}
