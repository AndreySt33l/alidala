package org.axteel.alidala.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "prod_id")
    private Long id;

    @NotBlank (message = "Title must not be empty")
    @Column(nullable = false)
    private String title;

    @NotBlank (message = "Title must not be empty")
    @Column (columnDefinition = "TEXT")
    private String description;

    private String category;

    @Column (name = "vendor_code")
    private String vendorCode;

    @Column (name = "quantity_in_stock", columnDefinition = "DECIMAL(16,2)")
    private Double quantityInStock;

    @Column (name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column (name = "wholesale_price", columnDefinition = "DECIMAL(16,2)")
    private Double wholesalePrice;

    @Column (name = "retail_price", columnDefinition = "DECIMAL(16,2)")
    private Double retailPrice;
}
