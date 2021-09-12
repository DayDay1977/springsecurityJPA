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
@Table(name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_employee_email", columnNames = "email")
        })
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(
            name="firstname",
            nullable = false
    )
    private String firstname;

    @Column(
            name="lastname",
            nullable = false
    )
    private String lastname;

    @Column(
            name="email",
            nullable = false
    )
    private String email;

    @Column(
            name="password",
            nullable = false
    )
    private String password;

    @Column(
            name="address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Column(
            name="street",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String street;

    @Column(
            name="enabled",
            nullable = false
    )
    private boolean active;

    @Column(nullable = false)
    private Date addedAt;

    @Column(nullable = false)
    private int mobile;

    public Employee(String firstname,
                    String lastname,
                    String email,
                    String password,
                    String address,
                    String street,
                    boolean active,
                    Date addedAt,
                    int mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.street = street;
        this.active = active;
        this.addedAt = addedAt;
        this.mobile = mobile;
    }

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "employee"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Invoice> invoices = new HashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "employee"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ProForma> proFormas = new HashSet<>();
}
