package com.example.mapsidbinding.repositories;

import com.example.mapsidbinding.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectorRepository extends JpaRepository<Sector, UUID> {
}