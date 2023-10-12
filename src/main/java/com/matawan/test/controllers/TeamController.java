package com.matawan.test.controllers;

import com.matawan.test.dtos.TeamRequestDto;
import com.matawan.test.dtos.TeamResponseDto;
import com.matawan.test.exceptions.TeamAlreadyExistException;
import com.matawan.test.services.TeamService;
import com.matawan.test.utils.SortingType;
import com.matawan.test.utils.SorttingAttribute;
import com.matawan.test.utils.mappers.TeamDtoToEntityMapper;
import com.matawan.test.utils.mappers.TeamEntityToDtoMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;
    private final TeamDtoToEntityMapper teamDtoToEntityMapper;
    private final TeamEntityToDtoMapper teamEntityToDtoMapper;

    public TeamController(final TeamService teamService,
                          final TeamDtoToEntityMapper teamDtoToEntityMapper,
                          final TeamEntityToDtoMapper teamEntityToDtoMapper) {
        this.teamService = teamService;
        this.teamDtoToEntityMapper = teamDtoToEntityMapper;
        this.teamEntityToDtoMapper = teamEntityToDtoMapper;
    }

    @PostMapping
    public void addTeam(@RequestBody @Valid final TeamRequestDto teamToAddDto) throws TeamAlreadyExistException {
        teamService.addTeam(teamDtoToEntityMapper.apply(teamToAddDto));
    }

    @GetMapping
    public List<TeamResponseDto> getTeamsSortedAndByPage(
            @RequestParam(value = "page", required = false, defaultValue = "1") final int page,
            @RequestParam(value = "sortBy", required = false, defaultValue = "NAME") final SorttingAttribute sorttingAttribute,
            @RequestParam(value = "sortType", required = false, defaultValue = "ASC") final SortingType sortingType){
        return teamService.getTeamsSortedAndByPage(page, sorttingAttribute, sortingType).stream()
                .map(teamEntityToDtoMapper::apply)
                .toList();
    }
}
