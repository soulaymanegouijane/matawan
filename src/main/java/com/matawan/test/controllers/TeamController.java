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

/**
 * This class is a REST controller that handles operations related to teams (creation, search, sorting and pagination ...).
 */
@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;
    private final TeamDtoToEntityMapper teamDtoToEntityMapper;
    private final TeamEntityToDtoMapper teamEntityToDtoMapper;
    /**
     * Constructor for the TeamController class.
     * Used to Inject the dependencies that are going to be used
     *
     * @param teamService           The service that manages team operations.
     * @param teamDtoToEntityMapper The mapper that converts team DTO objects to team entities.
     * @param teamEntityToDtoMapper The mapper that converts team entities to team DTO objects.
     */
    public TeamController(final TeamService teamService,
                          final TeamDtoToEntityMapper teamDtoToEntityMapper,
                          final TeamEntityToDtoMapper teamEntityToDtoMapper) {
        this.teamService = teamService;
        this.teamDtoToEntityMapper = teamDtoToEntityMapper;
        this.teamEntityToDtoMapper = teamEntityToDtoMapper;
    }

    /**
     * This method handles the creation of a new team.
     *
     * @param teamToAddDto The DTO object of the new team to create.
     * @throws TeamAlreadyExistException If a team with the same name or acronym already exists.
     */
    @PostMapping
    public void addTeam(@RequestBody @Valid final TeamRequestDto teamToAddDto)
            throws TeamAlreadyExistException {
        teamService.addTeam(teamDtoToEntityMapper.apply(teamToAddDto));
    }
    /**
     * This method retrieves a list of teams sorted and paginated based on the provided parameters.
     *
     * @param page           The page number to retrieve (default: 1).
     * @param sorttingAttribute The attribute by which to sort the teams (default: NAME).
     * @param sortingType    The sorting type (default: ASC).
     * @return A list of Team DTO objects representing the teams.
     */
    @GetMapping
    public List<TeamResponseDto> getTeamsSortedAndByPage(
            @RequestParam(value = "page", required = false, defaultValue = "1") final int page,
            @RequestParam(value = "sortBy", required = false, defaultValue = "NAME") final SorttingAttribute sorttingAttribute,
            @RequestParam(value = "sortType", required = false, defaultValue = "ASC") final SortingType sortingType){
        return teamService.getTeamsSortedAndByPage(page, sorttingAttribute, sortingType).stream()
                .map(teamEntityToDtoMapper::apply)
                .toList();
    }

    @GetMapping("/search")
    public List<TeamResponseDto> getTeamsByKeywordInNameOrAcronym(@RequestParam(value = "keyword", required = false) String keyword){
        return teamService.getTeamByKeyword(keyword).stream()
                .map(teamEntityToDtoMapper::apply)
                .toList();
    }
}
