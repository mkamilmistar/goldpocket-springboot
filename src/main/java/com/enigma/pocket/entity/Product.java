package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "m_products")
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String productName;
    private BigDecimal productPriceBuy;
    private BigDecimal productPriceSell;
    private String productImage;
    private Integer productStatus;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", priceBuy=" + productPriceBuy +
                ", priceSell=" + productPriceSell +
                ", productImage='" + productImage + '\'' +
                ", productStatus=" + productStatus +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
