package org.axteel.alidala.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "u_id")
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Column (nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column (nullable = false)
    private String password;

    private String phone;

    @Column (name = "first_name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "middle_name")
    private String middleName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee address;
}
