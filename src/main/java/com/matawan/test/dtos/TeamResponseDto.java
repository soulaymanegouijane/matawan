package com.matawan.test.dtos;

import com.matawan.test.entities.Player;

import java.util.Set;
/**
 * This record represents a DTO for retrieving a team from database and send it back to the client.
 */
public record TeamResponseDto (
        long teamId,
        String teamName,
        String teamAcronym,
        double teamBudget,
        Set<PlayerDto> players
){ }
