package com.enigma.pocket.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class HistoryProductSearchDto {
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp historyDate;
    private Integer priceBuy;
    private Integer priceSell;
    private String productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Timestamp historyDate) {
        this.historyDate = historyDate;
    }

    public Integer getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Integer priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Integer getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Integer priceSell) {
        this.priceSell = priceSell;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
