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
import se1app.applicationcore.teamcomponent.TeamNummer;

import java.util.List;

@RestController
class ApplicationFacadeController {

	@Autowired
	private SpielerComponentInterface spielerComponentInterface;

	@Autowired
	private TeamComponentInterface teamComponentInterface;


//	@RequestMapping(value = "/accounts/{number}", method = RequestMethod.GET)
//	public ResponseEntity<?> getaccount(@PathVariable("number") TeamNumberType teamNumber) {
//		Team team = spielerComponentInterface.getTeam(teamNumber);
//		if (team!=null) {
//			return new ResponseEntity<Team>(team, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

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

	@RequestMapping(value = "/teams/register", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> newTeam(@RequestBody int id, String name, Spieler spieler1, Spieler spieler2) throws Exception {
		
		teamComponentInterface.newTeam(3, name, spieler1, spieler2);
		
			return new ResponseEntity<Team>(HttpStatus.CREATED);
		
	}
	
//	@RequestMapping(value = "/register/branch", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public @ResponseBody ResponseEntity<Spieler> newBranch(@RequestBody SpielerNumberType bN) {
//		
//		spielerComponentInterface.newBranch(bN);
//		
//			return new ResponseEntity<Spieler>(HttpStatus.CREATED);
//		
//	}
	
	
	

//	@RequestMapping("/accounts")
//	public List<Account> getAllaccounts() {
//		return spielerComponentInterface.getAllAccounts();
//	}


}