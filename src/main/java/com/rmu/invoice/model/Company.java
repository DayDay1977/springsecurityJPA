package com.rmu.invoice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    private String type;

    private String size;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String street;

    public Company(String name, String type, String size, String address, String street) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.address = address;
        this.street = street;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "company"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Product> products = new HashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "company"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "company"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Invoice> invoices = new HashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "company"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ProForma> proFormas = new HashSet<>();
}
