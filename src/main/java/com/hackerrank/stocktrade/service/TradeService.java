package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.entity.User;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;
import com.hackerrank.stocktrade.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private UserRepository userRepository;

    public Trade getTrade(Long id){
        com.hackerrank.stocktrade.entity.Trade trade = tradeRepository.findById(id).orElse(null);
        if (trade == null) return null;
        User user = userRepository.findById(trade.getUserId()).orElse(null);
        return Converter.convertToModel(trade, user);
    }

    public void save(Trade trade) {
        com.hackerrank.stocktrade.model.User modelUser = trade.getUser();
        User user = userRepository.findById(modelUser.getId()).orElse(null);
        if (user == null){
            user = userRepository.save(Converter.convertToEntity(modelUser));
        }
        tradeRepository.save(Converter.convertToEntity(trade, user.getId()));
    }

    public void deleteAll() {
        tradeRepository.deleteAll();
    }

    public Trade getTradeById(Long id) {
        com.hackerrank.stocktrade.entity.Trade trade = tradeRepository.findById(id).orElse(null);
        if (trade == null){
            return null;
        }
        return Converter.convertToModel(trade, userRepository.findById(trade.getUserId()).orElse(null));
    }

    public List<Trade> getAllTrade() {
        List<com.hackerrank.stocktrade.entity.Trade> trade = tradeRepository.findAll();
        List<Trade> trades = new ArrayList<>();
        for(com.hackerrank.stocktrade.entity.Trade entity : trade){
            trades.add(Converter.convertToModel(entity, userRepository.findById(entity.getUserId()).orElse(null)));
        }
        return trades;
    }

    public List<Trade> getAllTradeByUserId(Long userId) {
        List<com.hackerrank.stocktrade.entity.Trade> trade = tradeRepository.findAllByUserId(userId);
        List<Trade> trades = new ArrayList<>();
        for(com.hackerrank.stocktrade.entity.Trade entity : trade){
            trades.add(Converter.convertToModel(entity, userRepository.findById(entity.getUserId()).orElse(null)));
        }
        return trades;
    }

    public List<Trade> getAllTradeByStockSymbol(String stockSymbol) {
        List<com.hackerrank.stocktrade.entity.Trade> trade = tradeRepository.findAllBySymbol(stockSymbol);
        List<Trade> trades = new ArrayList<>();
        for(com.hackerrank.stocktrade.entity.Trade entity : trade){
            trades.add(Converter.convertToModel(entity, userRepository.findById(entity.getUserId()).orElse(null)));
        }
        return trades;
    }

    public List<Trade> getAllTradeByStockSymbol(String stockSymbol, Long userID) {
        List<com.hackerrank.stocktrade.entity.Trade> trade = tradeRepository.findAllBySymbolAndUserId(stockSymbol, userID);
        List<Trade> trades = new ArrayList<>();
        for(com.hackerrank.stocktrade.entity.Trade entity : trade){
            trades.add(Converter.convertToModel(entity, userRepository.findById(entity.getUserId()).orElse(null)));
        }
        return trades;
    }
}
