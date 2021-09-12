package com.rmu.invoice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice",
        uniqueConstraints = {@UniqueConstraint(name = "UK_invoice_number", columnNames = "invoice_number")
})
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            updatable = false
    )
    private Long id;

    @Column(name = "invoice_number",
    nullable = false)
    private String invoiceNumber;

    @Column(name = "total_amount",
            nullable = false)
    private Double totalAmount;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "balance",
            nullable = false)
    private Double balance;

    @Column(
            nullable = false
    )
    private Date date;

    public Invoice(String invoiceNumber, Double totalAmount, Double amountPaid, Double balance, Date date) {
        this.invoiceNumber = invoiceNumber;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "invoice_products",
            joinColumns = {
                    @JoinColumn(name = "invoice_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id")
            })
    private Set<Product> products = new HashSet<>();
}
