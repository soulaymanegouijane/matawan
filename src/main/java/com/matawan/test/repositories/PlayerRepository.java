package com.matawan.test.repositories;

import com.matawan.test.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * this Class is a Repository that allows us to perform several methods on the database related to the entity Player
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
