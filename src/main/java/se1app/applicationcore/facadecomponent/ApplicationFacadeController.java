package se1app.applicationcore.facadecomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se1app.applicationcore.spielercomponent.Spieler;
import se1app.applicationcore.spielercomponent.SpielerComponentInterface;
import se1app.applicationcore.spielercomponent.SpielerNummer;
import se1app.applicationcore.teamcomponent.Team;
import se1app.applicationcore.teamcomponent.TeamComponentInterface;
import se1app.applicationcore.teamcomponent.TeamNotExistException;
import se1app.applicationcore.teamcomponent.TeamNummer;

import java.util.List;

@RestController
class ApplicationFacadeController {

	@Autowired
	private SpielerComponentInterface spielerComponentInterface;

	@Autowired
	private TeamComponentInterface teamComponentInterface;


	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Team> getAllTeams() {
		return teamComponentInterface.getAllTeams();
	}
	
	@RequestMapping(value = "/spieler/{number}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getSpieler(@PathVariable("number") int number) {
		SpielerNummer spielerNummer = new SpielerNummer(number);
		Spieler spieler = spielerComponentInterface.getSpielerBySpielerNummer(spielerNummer);
		if (spieler!=null) {
			return new ResponseEntity<Spieler>(spieler, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/spieler/@/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getSpieler(@PathVariable("name") String name) {
		Spieler spieler = spielerComponentInterface.getSpielerByName(name.toLowerCase());
		if (spieler!=null) {
			return new ResponseEntity<Spieler>(spieler, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/team/{number}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getTeam(@PathVariable("number") int number) {
		TeamNummer teamNummer = new TeamNummer(number);
		Team team = teamComponentInterface.getTeamByTeamNummer(teamNummer);
		if (team!=null) {
			return new ResponseEntity<Team>(team, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/team/@/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getTeam(@PathVariable("name") String name) {
		Team team = teamComponentInterface.getTeamByName(name.toLowerCase());
		if (team!=null) {
			return new ResponseEntity<Team>(team, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/spieler", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Spieler> getAllSpieler() {
		return spielerComponentInterface.getAllSpieler();
	}

	@RequestMapping(value = "/register/team", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<Team> newTeam(@RequestBody TeamSkelett team) {
		
		System.out.println(team.getSpieler1());
		System.out.println(team.getSpieler2());
		System.out.println(team.getName());
		
		Spieler spieler1 = spielerComponentInterface.getSpielerByName(team.getSpieler1());
		Spieler spieler2 = spielerComponentInterface.getSpielerByName(team.getSpieler2());
		Team teamName = teamComponentInterface.getTeamByName(team.getName());
		if(spieler1!=null&&spieler2!=null&&teamName==null) {
			
			int i = 0;
			while(teamComponentInterface.getTeamByTeamNummer(new TeamNummer(i))!=null) {
				i++;
			}
			
			try {
				teamComponentInterface.newTeam(i, team.getName(), spieler1, spieler2);
				spielerComponentInterface.updateTeamBySpieler(spieler1.getName(), team.getName());
				spielerComponentInterface.updateTeamBySpieler(spieler2.getName(), team.getName());
			} catch (TeamNotExistException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			return new ResponseEntity<Team>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/register/spieler", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<Spieler> newSpieler(@RequestBody SpielerSkelett spieler) {
		
		Spieler spielerName = spielerComponentInterface.getSpielerByName(spieler.getName().toLowerCase());
		if(spielerName==null) {
			
			int i = 0;
			while(spielerComponentInterface.getSpielerBySpielerNummer(new SpielerNummer(i))!=null) {
				i++;
			}
			
			spielerComponentInterface.newSpieler(i, spieler.getName(), spieler.getTwitch());
			return new ResponseEntity<Spieler>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

}