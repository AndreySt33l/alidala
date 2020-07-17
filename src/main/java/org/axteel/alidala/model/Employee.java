package org.axteel.alidala.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "emp_id")
    private Long id;

    @Column (name = "is_owner")
    private Boolean isOwner;

    @ManyToOne
    @JoinColumn(name="comp_id", nullable=false)
    private Company company;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
