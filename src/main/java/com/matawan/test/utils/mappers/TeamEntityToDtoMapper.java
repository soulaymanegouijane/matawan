package com.matawan.test.utils.mappers;

import com.matawan.test.dtos.TeamResponseDto;
import com.matawan.test.entities.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class is responsible for mapping Team Entity objects to Team DTOs.
 * You can use ready-to-use mappers such as ModelMapper or mapStruct
 * I used this (functional programming because I had problems using the other mappers on Java Records
 */
@Service
public class TeamEntityToDtoMapper implements Function<Team, TeamResponseDto> {

    private final PlayerEntityToDtoMapper playerEntityToDtoMapper;

    public TeamEntityToDtoMapper(PlayerEntityToDtoMapper playerEntityToDtoMapper) {
        this.playerEntityToDtoMapper = playerEntityToDtoMapper;
    }

    @Override
    public TeamResponseDto apply(Team team) {
        return new TeamResponseDto(team.getId(),
                team.getName(),
                team.getAcronym(),
                team.getBudget(),
                team.getPlayers().stream()
                        .map(playerEntityToDtoMapper::apply)
                        .collect(Collectors.toSet()));
    }
}
