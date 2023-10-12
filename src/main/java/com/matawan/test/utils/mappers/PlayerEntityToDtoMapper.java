package com.matawan.test.utils.mappers;

import com.matawan.test.dtos.PlayerDto;
import com.matawan.test.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * This class is responsible for mapping Player Entity objects to Player DTO.
 * You can use ready-to-use mappers such as ModelMapper or mapStruct
 * I used this (functional programming ) because I had problems using the other mappers on Java Records
 */
@Service
public class PlayerEntityToDtoMapper implements Function<Player, PlayerDto> {
    @Override
    public PlayerDto apply(Player player) {
        return new PlayerDto(player.getId(),
                player.getName(),
                player.getPosition());
    }
}
