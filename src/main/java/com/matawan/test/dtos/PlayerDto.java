package com.matawan.test.dtos;

public record PlayerDto(
        long playerId,
        String playerName,
        String playerPosition
) { }
