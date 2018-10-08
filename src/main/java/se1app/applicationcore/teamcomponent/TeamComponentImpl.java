package se1app.applicationcore.teamcomponent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se1app.applicationcore.spielercomponent.Spieler;
import se1app.applicationcore.spielercomponent.SpielerComponentInterface;

@Component
public class TeamComponentImpl implements TeamComponentInterface{

	@Autowired
	private TeamRepository teamRepository;
	
	public TeamComponentImpl(TeamRepository teamRepository, SpielerComponentInterface spielerComponentInterface) {
    	this.teamRepository = teamRepository;
    }
	
	@Override
    public void updateTeam(Team existingAccount)
    {
        if (existingAccount == null) {
            throw new IllegalArgumentException("Customer must not be null");
        }
        teamRepository.save(existingAccount);
    }
	
	
	
	@Override
	public void newTeam(int teamNumber, String name, Spieler spieler1, Spieler spieler2){
		
		try {
			teamRepository.save(new Team(teamNumber, name, spieler1, spieler2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void newTeam(Team team) {
		if (team!=null) {
			throw new IllegalArgumentException("Das Team ist mit dem Team " + team.getTeamNumber() + " gibt es bereits.");
		}
		teamRepository.save(team);
	}
	
	@Override
	public Team getTeamByTeamNummer(TeamNummer aN){
		return teamRepository.findByTeamNummer(aN);
	}
	
	@Override
	public Team getTeamByName(String name){
		return teamRepository.findByName(name);
	}

	@Override
	public List<Team> getAllTeams() {
		
		return teamRepository.findAll();
	}


	
}
