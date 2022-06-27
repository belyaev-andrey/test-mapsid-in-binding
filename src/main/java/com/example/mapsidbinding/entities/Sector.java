package com.example.mapsidbinding.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sector")
public class Sector {

    @NonNull
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // another fields
}