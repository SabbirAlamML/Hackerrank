package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

    @Autowired
    private TradeService tradeService;

    @PostMapping
    public ResponseEntity<Void> createTrade(@RequestBody Trade trade){
        Trade serviceTrade = tradeService.getTrade(trade.getId());
        if (serviceTrade != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        tradeService.save(trade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id){
        return tradeService.getTradeById(id);
    }

    @GetMapping
    public List<Trade> getAllTrade(){
        return tradeService.getAllTrade();
    }

    @GetMapping("/users/{userID}")
    public List<Trade> getAllTrade(@PathVariable Long userID){
        return tradeService.getAllTradeByUserId(userID);
    }

    @GetMapping("/stocks/{stockSymbol}")
    public List<Trade> getAllTradeByStockSymbol(@PathVariable String stockSymbol){
        return tradeService.getAllTradeByStockSymbol(stockSymbol);
    }

    @GetMapping("/users/{userID}/stocks/{stockSymbol}")
    public List<Trade> getAllTradeByStockSymbol(@PathVariable String stockSymbol, @PathVariable Long userID){
        return tradeService.getAllTradeByStockSymbol(stockSymbol, userID);
    }

}
