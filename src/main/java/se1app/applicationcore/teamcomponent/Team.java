package se1app.applicationcore.teamcomponent;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import se1app.applicationcore.spielercomponent.Spieler;
import se1app.applicationcore.spielercomponent.SpielerNummer;
import se1app.applicationcore.spielercomponent.SpielerRepository;

@Entity
public class Team {
	
	
//	teamNumber: TeamNumberType;
//	name: string;
//	member: Integer[];
	
	
	@Id
    @GeneratedValue
    private long id;
	
	@Column(unique=true)
	private TeamNummer teamNummer;
	
	@Column(unique=true)
	private String name;
	
	@Column
	@ElementCollection(targetClass=SpielerNummer.class)
	private List<String> member = new ArrayList<String>();

	public Team() {};
	
	public Team(int nummer, String name, Spieler spiler1, Spieler spiler2) throws Exception {
		if (name.isEmpty()) {
			throw new TeamNameNotSetException();
		} else {
			
			this.setTeamNumber(new TeamNummer(nummer));
			this.name = name.toLowerCase();
			this.addMember(spiler1);
			this.addMember(spiler2);
		}
	}
	
	public Team(int nummer, String name, int spieler1ID, String spieler1, String twitshspieler1, int spieler2ID, String spieler2, String twitshspieler2, SpielerRepository spielerRepository) throws Exception {
		if (name.isEmpty()) {
			throw new TeamNameNotSetException();
		} else {
			
			Spieler spieler1neu = new Spieler(spieler1ID, spieler1, twitshspieler1);
			Spieler spieler2neu = new Spieler(spieler2ID, spieler2, twitshspieler2);
			
			spielerRepository.save(spieler1neu);
			spielerRepository.save(spieler2neu);
			
			this.setTeamNumber(new TeamNummer(nummer));
			this.name = name.toLowerCase();
			this.addMember(spieler1neu);
			this.addMember(spieler2neu);
		}
	}
	
	public Team(Team team) throws TeamNameNotSetException {
		if (team.name.isEmpty()) {
			throw new TeamNameNotSetException();
		} else {
			this.teamNummer = team.teamNummer;
			this.name = team.name;
			this.member = team.member;
		}
	}
	
	
	public TeamNummer getTeamNumber() {
		return teamNummer;
	}

	public void setTeamNumber(TeamNummer teamNumber) {
		this.teamNummer = teamNumber;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getMember() {
		return member;
	}
	
	public void setMember(List<String> member) {
		this.member = member;
	}
	
	public void deleteMember(Spieler spieler) {
		this.member.add(spieler.getName());
	}
	
	public void addMember(Spieler spieler) throws ToManyPlayerInTeamException {
		if (this.member.size()>=2) {
			throw new ToManyPlayerInTeamException();
		}else {
			this.member.add(spieler.getName());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamNummer == null) ? 0 : teamNummer.hashCode());
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
		Team other = (Team) obj;
		if (teamNummer == null) {
			if (other.teamNummer != null)
				return false;
		} else if (!teamNummer.equals(other.teamNummer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[Team: " + teamNummer.toString() + " ]";
	}

}