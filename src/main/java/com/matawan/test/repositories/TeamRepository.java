package com.matawan.test.repositories;

import com.matawan.test.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Boolean existsByNameOrAcronym(String name, String acronym);
}
