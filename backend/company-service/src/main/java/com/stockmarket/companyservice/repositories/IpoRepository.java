package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.Company;
import com.stockmarket.companyservice.entities.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Integer> {
    Ipo findByCompanyId(int companyId);

    List<Ipo> findAllByOrderByDateTimeAsc();

    List<Ipo> findByStockExchangeId( int stockExchangeId);
}
