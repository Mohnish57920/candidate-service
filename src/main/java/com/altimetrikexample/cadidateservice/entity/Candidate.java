package com.altimetrikexample.cadidateservice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Candidate {

    @Id
    private Long Id;

    @NotNull
    private String name;

    @Column(unique = true)
    @NotNull
    @Email
    private String email;

    @Min(0)
    @NotNull
    private Integer salary;

    @Min(0)
    @NotNull
    private Double expense;
}
