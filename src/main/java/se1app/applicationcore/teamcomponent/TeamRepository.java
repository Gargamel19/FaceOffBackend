package se1app.applicationcore.teamcomponent;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Serializable> {

	Team findByTeamNummer(TeamNummer teamNummer);
	Team findByName(String name);
	
}
 