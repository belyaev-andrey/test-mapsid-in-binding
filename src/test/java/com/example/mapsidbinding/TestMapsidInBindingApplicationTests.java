package com.example.mapsidbinding;

import com.example.mapsidbinding.entities.AllocationSector;
import com.example.mapsidbinding.entities.Sector;
import com.example.mapsidbinding.repositories.AllocationSectorRepository;
import com.example.mapsidbinding.repositories.SectorRepository;
import com.example.mapsidbinding.service.AllocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
class TestMapsidInBindingApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testService(@Autowired AllocationService service, @Autowired SectorRepository sectorRepository) {
        List<Sector> sectors = sectorRepository.findAll();
        List<AllocationSector> allocationSectors = service.findBySectors(sectors)
                .stream().sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                .toList();
        assertEquals(2, allocationSectors.size());
        assertEquals("alloc sector 1", allocationSectors.get(0).getName());
        assertEquals("alloc sector 2", allocationSectors.get(1).getName());
    }




}