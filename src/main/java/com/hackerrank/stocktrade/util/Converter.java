package com.hackerrank.stocktrade.util;

import com.hackerrank.stocktrade.entity.Trade;
import com.hackerrank.stocktrade.entity.User;

public class Converter {

    private Converter() {
    }

    public static com.hackerrank.stocktrade.model.Trade convertToModel(Trade trade, User user) {
        return new com.hackerrank.stocktrade.model.Trade(
                trade.getId(),
                trade.getType(),
                convertToModel(user),
                trade.getSymbol(),
                trade.getShares(),
                trade.getPrice(),
                trade.getTimestamp()
        );
    }

    public static com.hackerrank.stocktrade.model.User convertToModel(User user) {
        return new com.hackerrank.stocktrade.model.User(user.getId(), user.getName());
    }

    public static User convertToEntity(com.hackerrank.stocktrade.model.User modelUser) {
        return new User(modelUser.getId(), modelUser.getName());
    }

    public static Trade convertToEntity(com.hackerrank.stocktrade.model.Trade trade, Long userId) {
        return new Trade(
                trade.getId(),
                trade.getType(),
                userId,
                trade.getSymbol(),
                trade.getShares(),
                trade.getPrice(),
                trade.getTimestamp()
        );
    }
}
