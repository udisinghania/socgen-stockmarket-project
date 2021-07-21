package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

    @Query(value="select * from stock_price where stock_id=(select id from stock where company_id= :companyId and exchange_id= :exchangeId) and timestamp between :fromTime and :toTime", nativeQuery=true)
    List<StockPrice> getStockPriceList(@Param("companyId") int companyId, @Param("exchangeId") int exchangeId, @Param("fromTime") String fromTime, @Param("toTime") String toTime);

    @Modifying
    @Transactional
    @Query(value="insert into stock_price(price, timestamp, stock_id) values(:price, :timestamp, (select id from stock where company_id= :companyId and exchange_id= :exchangeId));", nativeQuery=true)
    int addStockPrice(@Param("companyId") int companyId, @Param("exchangeId") int exchangeId, @Param("price") double price, @Param("timestamp") Timestamp timestamp);

}
