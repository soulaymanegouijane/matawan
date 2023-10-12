package com.matawan.test.utils.mappers;

import com.matawan.test.dtos.PlayerDto;
import com.matawan.test.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;
/**
 * This class is responsible for mapping PlayerDto objects to Player entities.
 * You can use ready-to-use mappers such as ModelMapper or mapStruct
 * I used this (functional programming because I had problems using the other mappers on Java Records
 */
@Service
public class PlayerDtoToEntityMapper implements Function<PlayerDto, Player> {
    @Override
    public Player apply(PlayerDto playerDto) {
        return Player.builder()
                .name(playerDto.playerName())
                .position(playerDto.playerPosition())
                .build();
    }
}
