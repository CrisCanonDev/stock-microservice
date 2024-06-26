package com.ccdev.stock_microservice.Repository;

import com.ccdev.stock_microservice.Entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

    Optional<StockEntity> findByCode(String code);
}
