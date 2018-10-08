package se1app.applicationcore.teamcomponent;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se1app.applicationcore.spielercomponent.Spieler;

@Repository
public interface TeamRepository extends JpaRepository<Team, Serializable> {

	Team findByTeamNummer(TeamNummer teamNummer);
	Team findByName(String name);
	
}
 