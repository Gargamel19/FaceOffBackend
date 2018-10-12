package se1app.applicationcore.spielercomponent;

import java.util.List;

public interface SpielerComponentInterface {
	public List<Spieler> getAllSpieler();
//	public Team getTeam(Spieler spieler);
	public Spieler getSpielerBySpielerNummer(SpielerNummer spielerNummer);
	public Spieler getSpielerByName(String name);
	void newSpieler(int nummer, String name, String twitch);
	void newSpielerS(String nummer, String name, String twitch);
	void updateTeamBySpieler(String spieler, String team);
}
