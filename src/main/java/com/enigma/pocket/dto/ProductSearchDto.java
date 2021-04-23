package com.enigma.pocket.dto;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

public class ProductSearchDto {

    private String id;
    private String productName;
    private BigDecimal productPriceBuy;
    private BigDecimal productPriceSell;
    private String productImage;
    private Integer productStatus;

    @Column(name = "created_at")
    private Date createdDate;
    @Column(name = "updated_at")
    private Date updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(BigDecimal productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
