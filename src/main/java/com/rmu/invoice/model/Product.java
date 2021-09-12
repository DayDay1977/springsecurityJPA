package com.rmu.invoice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    private String name;
    private String category;
    private double unitPrice;
    private int quantity;

    public Product(String productName, String productCategory, double unitPrice, int quantity) {
        this.name = productName;
        this.category = productCategory;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @ManyToOne(
                fetch = FetchType.LAZY
    )
    @JoinColumn(name = "company_id")
    private Company company;
}
