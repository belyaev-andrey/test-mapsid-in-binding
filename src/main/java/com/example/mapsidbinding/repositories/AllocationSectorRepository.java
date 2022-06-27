package com.example.mapsidbinding.repositories;

import com.example.mapsidbinding.entities.AllocationSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AllocationSectorRepository extends JpaRepository<AllocationSector, UUID>, JpaSpecificationExecutor<AllocationSector> {
}