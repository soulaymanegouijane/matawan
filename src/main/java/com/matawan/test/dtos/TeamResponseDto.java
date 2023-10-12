package com.matawan.test.dtos;

import com.matawan.test.entities.Player;

import java.util.Set;

public record TeamResponseDto (
        long teamId,
        String teamName,
        String teamAcronym,
        double teamBudget,
        Set<PlayerDto> players
){ }
