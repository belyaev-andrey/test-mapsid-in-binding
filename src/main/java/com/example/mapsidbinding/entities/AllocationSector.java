package com.example.mapsidbinding.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "allocation_sector")
public class AllocationSector {

    @Id
    @Column(name = "sector_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private UUID sectorId;

    @MapsId
    @OneToOne //@ManyToOne
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @Column(name = "name")
    private String name;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// another fields

}