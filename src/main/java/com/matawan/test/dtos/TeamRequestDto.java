package com.matawan.test.dtos;

import jakarta.validation.constraints.*;

import java.util.Set;

public record TeamRequestDto(
        @NotBlank(message = "The Name is required")
        @Size(min = 3, message = "The name should be have at least 3 characters")
        String teamName,

        @NotBlank(message = "the Acronym is required")
        String teamAcronym,


        @Positive(message = "the budget should be a valid number and positive")
        double teamBudget,

        Set<PlayerDto> players
) { }
