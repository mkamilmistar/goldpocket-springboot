package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_purchase_details")
public class PurchaseDetail {

    @Id
    @Column(name = "purchase_detail_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne
    private Product product;

    private BigDecimal price;
    private BigDecimal quantityInGram;

    @ManyToOne
    private Purchase purchase;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantityInGram() {
        return quantityInGram;
    }

    public void setQuantityInGram(BigDecimal quantityInGram) {
        this.quantityInGram = quantityInGram;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
