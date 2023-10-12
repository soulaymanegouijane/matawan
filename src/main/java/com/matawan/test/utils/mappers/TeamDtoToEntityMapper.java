package com.matawan.test.utils.mappers;

import com.matawan.test.dtos.TeamRequestDto;
import com.matawan.test.entities.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class is responsible for mapping Team DTO objects to Team entities.
 * You can use ready-to-use mappers such as ModelMapper or mapStruct
 * I used this (functional programming because I had problems using the other mappers on Java Records
 */
@Service
public class TeamDtoToEntityMapper implements Function<TeamRequestDto, Team> {

    private final PlayerDtoToEntityMapper playerDtoToEntityMapper;

    public TeamDtoToEntityMapper( final PlayerDtoToEntityMapper playerDtoToEntityMapper) {
        this.playerDtoToEntityMapper = playerDtoToEntityMapper;
    }

    @Override
    public Team apply(TeamRequestDto teamRequestDto) {
        return Team.builder()
                .name(teamRequestDto.teamName())
                .acronym(teamRequestDto.teamAcronym())
                .budget(teamRequestDto.teamBudget())
                .players(teamRequestDto.players().stream()
                        .map(playerDtoToEntityMapper::apply)
                        .collect(Collectors.toSet()))
                .build();
    }
}
