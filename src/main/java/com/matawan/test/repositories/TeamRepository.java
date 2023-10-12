package com.matawan.test.repositories;

import com.matawan.test.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * this Class is a Repository that allows us to perform several methods on the database related to the entity Team
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Boolean existsByNameOrAcronym(String name, String acronym);
}
