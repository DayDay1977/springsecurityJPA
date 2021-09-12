package com.rmu.invoice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "proForma",
        uniqueConstraints = {@UniqueConstraint(name = "UK_proforma_number", columnNames = "invoiceNumber")
        })
public class ProForma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            updatable = false
    )
    private Long id;

    @Column(nullable = false)
    private String invoiceNumber;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private Date date;

    public ProForma(String invoiceNumber, Double totalAmount, Date date) {
        this.invoiceNumber = invoiceNumber;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "proforma_products",
            joinColumns = {
                    @JoinColumn(name = "proforma_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id")
            })
    private Set<Product> products = new HashSet<>();
}
