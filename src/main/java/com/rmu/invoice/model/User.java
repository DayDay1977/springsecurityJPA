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
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_user_email", columnNames = "email")
        })

public class User implements Serializable {
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
            nullable = false
    )
    private String address;

    @Column(
            name="street",
            nullable = false
    )
    private String street;

    @Column(
            name="enabled",
            nullable = false
    )
    private boolean active;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private int mobile;

    public User(String firstname,
                String lastname,
                String email,
                String password,
                String address,
                String street,
                boolean active,
                Date createdAt,
                int mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.street = street;
        this.active = active;
        this.createdAt = createdAt;
        this.mobile = mobile;
    }

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Company> companies = new HashSet<>();
}
