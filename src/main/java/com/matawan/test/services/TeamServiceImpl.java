package com.matawan.test.services;

import com.matawan.test.entities.Team;
import com.matawan.test.exceptions.TeamAlreadyExistException;
import com.matawan.test.repositories.TeamRepository;
import com.matawan.test.utils.SortingType;
import com.matawan.test.utils.SorttingAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    private static final int PAGE_SIZE = 3;

    public TeamServiceImpl(final TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void addTeam(Team teamToSave) throws TeamAlreadyExistException {
        if(teamRepository.existsByNameOrAcronym(teamToSave.getName(), teamToSave.getAcronym())) throw new TeamAlreadyExistException("a Team with the same name or acronym already exist !");
        teamRepository.save(teamToSave);
    }

    @Override
    public List<Team> getTeamsSortedAndByPage(int page, SorttingAttribute sorttingAttribute, SortingType sortingType) {
        Page<Team> results = switch (sortingType) {
            case ASC -> (switch (sorttingAttribute) {
                case NAME -> teamRepository.findAll(PageRequest.of(page - 1, PAGE_SIZE, Sort.by("name").ascending()));
                case BUDGET -> teamRepository.findAll(PageRequest.of(page - 1, PAGE_SIZE, Sort.by("budget").ascending()));
                case ACRONYM -> teamRepository.findAll(PageRequest.of(page - 1, PAGE_SIZE, Sort.by("acronym").ascending()));
            });
            case DESC -> (switch (sorttingAttribute) {
                case NAME -> teamRepository.findAll(PageRequest.of(page-1, PAGE_SIZE, Sort.by("name").descending()));
                case BUDGET -> teamRepository.findAll(PageRequest.of(page-1, PAGE_SIZE, Sort.by("budget").descending()));
                case ACRONYM -> teamRepository.findAll(PageRequest.of(page-1, PAGE_SIZE, Sort.by("acronym").descending()));
            });
        };
        return results.getContent();
    }
}
