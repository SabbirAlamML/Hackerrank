package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findAllByUserId(Long userId);

    List<Trade> findAllBySymbol(String stockSymbol);

    List<Trade> findAllBySymbolAndUserId(String stockSymbol, Long userID);
}
