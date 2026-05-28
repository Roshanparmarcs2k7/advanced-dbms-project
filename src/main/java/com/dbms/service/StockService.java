package com.dbms.inventorysystem.service;

import com.dbms.inventorysystem.model.Stock;
import com.dbms.inventorysystem.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Integer id) {
        return stockRepository.findById(id).orElse(null);
    }

    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    public void deleteStock(Integer id) {
        stockRepository.deleteById(id);
    }
}