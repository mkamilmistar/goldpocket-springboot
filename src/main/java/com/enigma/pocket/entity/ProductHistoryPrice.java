package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "m_history_prices")
public class ProductHistoryPrice {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date historyDate;
    private BigDecimal priceBuy;
    private BigDecimal priceSell;
    private String productId;

    public ProductHistoryPrice() {
    }

    public ProductHistoryPrice(Product product) {
        this.historyDate = product.getUpdatedDate();
        this.priceBuy = product.getProductPriceBuy();
        this.priceSell = product.getProductPriceSell();
        this.productId = product.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }

    public BigDecimal getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(BigDecimal priceBuy) {
        this.priceBuy = priceBuy;
    }

    public BigDecimal getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(BigDecimal priceSell) {
        this.priceSell = priceSell;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "HistoryProduct{" +
                "id='" + id + '\'' +
                ", historyDate=" + historyDate +
                ", priceBuy=" + priceBuy +
                ", priceSell=" + priceSell +
                ", productId='" + productId + '\'' +
                '}';
    }
}
