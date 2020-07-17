package org.axteel.alidala.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

/**
 * При регистрации комании user автоматически
 * становится в таблице employee(is_owner)
 * хозяином этой компании
 * */

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "com_id")
    private Long id;

    @NotBlank(message = "Company title is mandatory")
    @Column (nullable = false)
    private String title;

    private String description;

    @Column (name = "est_date")
    private Date dateOfEstablishment;

    private String fax;

    private String website;

    @Column (name = "business_type")
    private String businessType;

    private String address;

    @Column (name = "employee_number")
    private Long employeeNumber;

    @OneToMany (mappedBy = "company")
    private Set<Employee> employees;

    /*
    @ManyToOne
    @JoinColumn(name="u_id", nullable=false)
    private User user;
    */
}
