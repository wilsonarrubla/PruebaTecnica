package com.ParametaSAS.main.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="empleado")
public class Empleado {

    @Column
    @NotBlank(message = "Name is mandatory")
    @NonNull
    private String names;

    @Column
    @NotBlank(message = "lastName is mandatory")
    @NonNull
    private String lastNames;

    @Column
    @NotBlank(message = "documetType is mandatory")
    @NonNull
    private String documetType;

    @Id
    @NotBlank(message = "documetNumber is mandatory")
    @NonNull
    private String documetNumber;

    @Column
    @NonNull

    private LocalDate dataBirth;

    @Column
    @NonNull

    private LocalDate startDateEnterprise;

    @Column
    @NotBlank(message = "position is mandatory")
    @NonNull
    private String position;

    @Column
    @NotNull(message = "Salary is mandatory")
    @Min(1)
    @NonNull

    private Double salary;
    @Column
    private String employeeAge;

    @Column

    private  String timeEnterprise;

}
