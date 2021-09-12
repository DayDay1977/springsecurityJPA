package com.rmu.invoice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @OneToOne(mappedBy = "role")
    @JsonIgnore
    private User user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "role")
    @JsonIgnore
    private Employee employee;
}
