package com.example.mapsidbinding.service;

import com.example.mapsidbinding.entities.AllocationSector;
import com.example.mapsidbinding.entities.AllocationSector_;
import com.example.mapsidbinding.entities.Sector;
import com.example.mapsidbinding.entities.Sector_;
import com.example.mapsidbinding.repositories.AllocationSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    @Autowired
    private AllocationSectorRepository allocationSectorRepository;

    public List<AllocationSector> findBySectors(List<Sector> sectors) {
        return allocationSectorRepository.findAll(sectorFilter(sectors).and(fetchSector()));
    }

//    public Specification<AllocationSector> sectorFilter(List<Sector> sectors) {
//        return (root, query, criteriaBuilder) -> root.get(AllocationSector_.sector)
//                .get(Sector_.id)
//                .in(sectors.stream()
//                        .map(Sector::getId)
//                        .toList());
//    }

    public Specification<AllocationSector> sectorFilter(List<Sector> sectors) {
        return (root, query, criteriaBuilder) -> root.get(AllocationSector_.sector).in(sectors);
    }

    public static Specification<AllocationSector> fetchSector() {
        return (root, query, criteriaBuilder) -> {
            root.fetch(AllocationSector_.sector);
            return null;
        };
    }

}