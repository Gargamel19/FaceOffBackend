package se1app.applicationcore.spielercomponent;

import java.awt.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import se1app.applicationcore.teamcomponent.Team;


@Entity
public class Spieler {

//	spielerNumber: SpielerNumberType;
//	name: string;
//	twitch: string;
//	teams: Team[];
	
	
	@Id
    @GeneratedValue
    private long id;
	
	@Column(unique=true)
	private SpielerNummer spielerNummer;
	
	@Column(unique=true)
    private String name;
	
    private String twitch;
    
    private ArrayList<String> teams = new ArrayList<String>();
    
    private int kills = 0;
    
    public Spieler() {};

	public Spieler(int nummer, String name, String twitch) {
		
		this.setSpielerNumber(new SpielerNummer(nummer));
		this.name = name.toLowerCase();
		this.twitch = twitch.toLowerCase();
		
	}
	
	public SpielerNummer getSpielerNumber() {
		return spielerNummer;
	}
	
	public void setSpielerNumber(SpielerNummer spielerNumber) {
		this.spielerNummer = spielerNumber;
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getTwitch() {
		return twitch;
	}
	
	public void setTwitch(String twitch) {
		this.twitch = twitch;
	}
	
	public ArrayList<String> getTeams() {
		return teams;
	}
	
	public void setTeams(ArrayList<String> teams) {
		this.teams = teams;
	}
	
	public void addTeam(String team) {
		this.teams.add(team);
	}
	
	public void deleteTeam(String team) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i)==team) {
				this.teams.remove(i);
				break;
			}
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + spielerNummer.getId().intValue();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spieler other = (Spieler) obj;
		if (spielerNummer != other.spielerNummer)
			return false;
		return true;
	}
    
	@Override
	public String toString() {
		return "[Spieler: " + spielerNummer.toString() + " ]";
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
	
}
