package com.ccdev.stock_microservice.Controller;

import com.ccdev.stock_microservice.Entity.StockEntity;
import com.ccdev.stock_microservice.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    public StockRepository stockRepository;

    @RequestMapping("/{code}")
    public boolean stockAvailable(@PathVariable String code){


        Optional<StockEntity> stock = stockRepository.findByCode(code);

        stock.orElseThrow(() -> new RuntimeException("Stock not found" + code));

        return stock.get().getQuantity() > 0;
    }
}
