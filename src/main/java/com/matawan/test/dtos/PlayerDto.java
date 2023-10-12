package com.matawan.test.dtos;


/**
 * This record represents a Data Transfer Object (DTO) for player information.
 */
public record PlayerDto(
        long playerId,
        String playerName,
        String playerPosition
) { }
