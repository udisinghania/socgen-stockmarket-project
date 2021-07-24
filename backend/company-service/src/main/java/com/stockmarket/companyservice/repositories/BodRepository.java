package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.BoardOfDirectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BodRepository extends JpaRepository<BoardOfDirectors,Integer> {
    Optional<BoardOfDirectors> findByName(String bod);
}
