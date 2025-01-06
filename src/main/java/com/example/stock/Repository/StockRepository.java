package com.example.stock.Repository;

import com.example.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository<Stock, Long> {
}
