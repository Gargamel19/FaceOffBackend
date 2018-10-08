package se1app.applicationcore.spielercomponent;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se1app.applicationcore.spielercomponent.Spieler;

@Repository
public interface SpielerRepository extends JpaRepository<Spieler, Serializable> {
	
	Spieler findBySpielerNummer(SpielerNummer spielerNumber);
	Spieler findByName(String name);
}
