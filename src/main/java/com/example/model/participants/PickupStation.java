package com.example.model.participants;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Entity
@Table(name = "station")
public class PickupStation {
    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "station")
    private Set<PickupStationVendorDetails> vendors = new HashSet<>();

    public PickupStation() {}

    public PickupStation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void addVendor(Vendor vendor) {
        PickupStationVendorDetails details = new PickupStationVendorDetails(vendor, this);
        vendors.add(details);
    }

    public Set<Vendor> getVendors() {
        return vendors.stream().map(PickupStationVendorDetails::getVendor).collect(toSet());
    }
}
