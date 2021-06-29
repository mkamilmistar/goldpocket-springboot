package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "m_pockets")
public class Pocket {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String pocketName;
    private Double pocketQty;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

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

    public void setCustomer(Customer customer) {
      this.customer = customer;
    }

  public Customer getCustomer() {
    return customer;
  }

  public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Pocket{" +
                "id='" + id + '\'' +
                ", pocketName='" + pocketName + '\'' +
                ", pocketQty=" + pocketQty +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
