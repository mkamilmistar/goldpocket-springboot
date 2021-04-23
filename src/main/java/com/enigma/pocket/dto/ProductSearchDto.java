package com.enigma.crudProduct.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class ProductSearchDto {

    private String id;
    private String productImage;
    private String productName;
    private Integer productPriceBuy;
    private Integer productPriceSell;
    private Integer productStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(Integer productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public Integer getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(Integer productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
