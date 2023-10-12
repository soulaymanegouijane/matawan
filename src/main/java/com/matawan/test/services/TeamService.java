package com.matawan.test.services;

import com.matawan.test.dtos.TeamResponseDto;
import com.matawan.test.entities.Team;
import com.matawan.test.exceptions.TeamAlreadyExistException;
import com.matawan.test.utils.SortingType;
import com.matawan.test.utils.SorttingAttribute;

import java.util.List;
/**
 * This interface defines the methods for services related to teams.
 */
public interface TeamService {
    /**
     * Adds a new team to the database.
     *
     * @param team The team to be added.
     * @throws TeamAlreadyExistException If a team with the same name or acronym already exists.
     */
    void addTeam(Team team) throws TeamAlreadyExistException;
    /**
     * Retrieves a list of teams sorted and paginated based on the provided parameters.
     *
     * @param page             The page number to retrieve.
     * @param sorttingAttribute The attribute by which to sort the teams.
     * @param sortingType      The sorting type (ascending or descending).
     * @return A list of teams meeting the specified criteria.
     */
    List<Team> getTeamsSortedAndByPage(int page, SorttingAttribute sorttingAttribute, SortingType sortingType);
}
