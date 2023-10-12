package com.matawan.test.services;

import com.matawan.test.dtos.TeamResponseDto;
import com.matawan.test.entities.Team;
import com.matawan.test.exceptions.TeamAlreadyExistException;
import com.matawan.test.utils.SortingType;
import com.matawan.test.utils.SorttingAttribute;

import java.util.List;

public interface TeamService {
    void addTeam(Team apply) throws TeamAlreadyExistException;

    List<Team> getTeamsSortedAndByPage(int page, SorttingAttribute sorttingAttribute, SortingType sortingType);
}
