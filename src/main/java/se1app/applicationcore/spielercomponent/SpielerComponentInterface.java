package se1app.applicationcore.spielercomponent;

import java.util.List;

public interface SpielerComponentInterface {
//	public void newSpieler(Spieler spieler);
	public List<Spieler> getAllSpieler();
//	public Team getTeam(Spieler spieler);
	public Spieler getSpielerBySpielerNummer(SpielerNummer spielerNummer);
}
