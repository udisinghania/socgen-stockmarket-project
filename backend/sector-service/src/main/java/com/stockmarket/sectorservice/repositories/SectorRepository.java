package com.stockmarket.sectorservice.repositories;

import com.stockmarket.sectorservice.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {

    Sector findByName(String sectorName);
}
