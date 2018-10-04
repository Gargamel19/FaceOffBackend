package se1app.applicationcore.teamcomponent;

import java.util.List;

import se1app.applicationcore.spielercomponent.Spieler;


public interface TeamComponentInterface {
	public void newTeam(int teamNummer, String name, Spieler spieler1, Spieler spieler2) throws TeamNotExistException;
	//public Team getTeam(TeamNumberType aN);
	public void newTeam(Team team);
	public List<Team> getAllTeams();
	void updateTeam(Team existingTeam);
}

