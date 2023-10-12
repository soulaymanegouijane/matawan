package com.matawan.test.utils.mappers;

import com.matawan.test.dtos.PlayerDto;
import com.matawan.test.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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
