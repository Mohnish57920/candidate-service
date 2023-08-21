package com.altimetrikexample.cadidateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CandidateDto {

    private Long Id;

    @NotNull
    private String name;

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
