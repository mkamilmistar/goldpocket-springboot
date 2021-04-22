package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_pockets")
public class Pocket {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String pocketName;
    private Double pocketQty;
    private String customerId;
    private String productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPocketName() {
        return pocketName;
    }

    public void setPocketName(String pocketName) {
        this.pocketName = pocketName;
    }

    public Double getPocketQty() {
        return pocketQty;
    }

    public void setPocketQty(Double pocketQty) {
        this.pocketQty = pocketQty;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
