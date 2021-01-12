package com.hackerrank.stocktrade.entity;

import com.hackerrank.stocktrade.model.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    private Long id;

    @Column
    private String type;

    @Column
    private Long userId;

    @Column
    private String symbol;

    @Column
    private Integer shares;

    @Column
    private Float price;

    @Column
    private String timestamp;
    
    public Trade() {
    }

    public Trade(Long id, String type, Long userId, String symbol, Integer shares, Float price, String timestamp) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
