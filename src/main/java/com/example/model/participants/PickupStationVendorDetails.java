package com.example.model.participants;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "station_vendors")
public class PickupStationVendorDetails {
    @EmbeddedId
    private PickupStationVendorKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vendorId")
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stationId")
    @JoinColumn(name = "station_id")
    private PickupStation station;

    private PickupStationVendorDetails() {}

    public PickupStationVendorDetails(Vendor vendor, PickupStation  station) {
        this.vendor = vendor;
        this.station = station;
        this.id = new PickupStationVendorKey(vendor.getId(), station.getId());
    }

    public Vendor getVendor() {
        return vendor;
    }

    public PickupStation getStation() {
        return station;
    }
}
