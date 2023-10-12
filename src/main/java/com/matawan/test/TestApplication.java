package com.matawan.test;

import com.matawan.test.entities.Player;
import com.matawan.test.entities.Team;
import com.matawan.test.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	/**
	 * This method is executed once the application context is loaded. It is responsible for creating test data in the database.
	 *
	 * @param args The command-line arguments.
	 * @throws Exception If an exception occurs during the execution.
	 */
	@Override
	public void run(String... args) throws Exception {
		Player p1 = Player.builder()
				.name("hakimi achraf")
				.position("defender")
				.build();
		Player p2 = Player.builder()
				.name("ziyech")
				.position("goal keeper")
				.build();
		Player p3 = Player.builder()
				.name("yassine bono")
				.position("goal keeper")
				.build();
		Player p4 = Player.builder()
				.name("sabiri ahmed")
				.position("attacker")
				.build();
		Player p5 = Player.builder()
				.name("amrabat soufiane")
				.position("defender")
				.build();
		Player p6 = Player.builder()
				.name("nassiri")
				.position("attacker")
				.build();
		Team team1 = Team.builder()
				.acronym("PSG")
				.name("Paris Saint Germain")
				.budget(112002029.252)
				.players(Set.of(p1,p2))
				.build();
		Team team2 = Team.builder()
				.acronym("NICE")
				.name("NICE")
				.budget(984899.252)
				.players(Set.of(p3,p4))
				.build();
		Team team3 = Team.builder()
				.acronym("Sophia Antipolis")
				.name("SAP")
				.budget(855255999.252)
				.players(Set.of(p5,p6))
				.build();
		teamRepository.saveAll(List.of(team1,team2,team3));
	}
}
