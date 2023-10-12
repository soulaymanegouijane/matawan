package com.matawan.test.utils.mappers;

import com.matawan.test.dtos.PlayerDto;
import com.matawan.test.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlayerEntityToDtoMapper implements Function<Player, PlayerDto> {
    @Override
    public PlayerDto apply(Player player) {
        return new PlayerDto(player.getId(),
                player.getName(),
                player.getPosition());
    }
}
