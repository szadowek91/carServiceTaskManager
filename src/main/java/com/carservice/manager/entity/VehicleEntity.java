package com.carservice.manager.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = VehicleEntity.TABLE_NAME)
public class VehicleEntity {

    public static final String TABLE_NAME = "vehicle";
    public static final String COLUMN_PREFIX = "v_";

    @Id
//    @GeneratedValue() //MySql
//    @Column(name = COLUMN_PREFIX + "id") //MySql
//    @GenericGenerator(name = COLUMN_PREFIX+"id",strategy = "increment") //FireBird
//    @GeneratedValue(generator = COLUMN_PREFIX+"id")//FireBird
    private Long id;

    @NotNull
    @Size(min = 2, max = 10)
    @Column(name = COLUMN_PREFIX+"registration_number", nullable = false)
    private String registrationNumber;

    @NotEmpty
    @Column(name = COLUMN_PREFIX+"mark", nullable = false)
    private String mark;

    @Column(name = COLUMN_PREFIX+"model")
    private String model;

    @Column(name = COLUMN_PREFIX+"color")
    private String color;

    @Min(1850)
    @Max(2022)
    @Column(name = COLUMN_PREFIX+"prod_year")
    private int productionYear;

    @Column(name = COLUMN_PREFIX+"add_date")
    private Date admissionDate;

    @Column(name = COLUMN_PREFIX+"rep_date")
    private Date repairDate;

    @Column(name = COLUMN_PREFIX+"is_repaired")
    private boolean status = false;


    public VehicleEntity(@NotNull @Size(min = 2, max = 10) String registrationNumber, @NotEmpty String mark, String model, String color, @Min(1850) @Max(2022) int productionYear) {
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
    }
}
