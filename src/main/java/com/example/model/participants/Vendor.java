package com.example.model.participants;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "vendor")
    private Set<PickupStationVendorDetails> stations = new HashSet<>();

    public Vendor() {}

    public Vendor(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void add(PickupStation station) {
        PickupStationVendorDetails details = new PickupStationVendorDetails(this, station);
        stations.add(details);
    }

    public Set<PickupStation> getStations() {
        return stations.stream().map(PickupStationVendorDetails::getStation).collect(toSet());
    }
}
