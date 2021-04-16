package com.example.model.participants;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PickupStationVendorKey implements Serializable {
    @Column(name = "vendor_id")
    private UUID vendorId;

    @Column(name = "station_id")
    private Long stationId;

    private PickupStationVendorKey() {}

    public PickupStationVendorKey(UUID vendorId, Long stationId) {
        this.vendorId = vendorId;
        this.stationId = stationId;
    }
}
