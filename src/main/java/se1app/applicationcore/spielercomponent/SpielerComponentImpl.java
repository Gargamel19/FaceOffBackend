package se1app.applicationcore.spielercomponent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpielerComponentImpl implements SpielerComponentInterface{

	@Autowired
	private SpielerRepository spielerRepository;
	
	
    public SpielerComponentImpl(SpielerRepository spielerRepository) {
    	this.spielerRepository = spielerRepository;
    }
    
    @Override
    public List<Spieler> getAllSpieler(){
    	return spielerRepository.findAll();
    }
	
    @Override
    public Spieler getSpielerBySpielerNummer(SpielerNummer bN){
    	return spielerRepository.findBySpielerNummer(bN);
    }

	@Override
	public Spieler getSpielerByName(String name) {
		return spielerRepository.findByName(name.toLowerCase());
	}

	@Override
	public void newSpieler(int nummer, String name, String twitch){
		
		try {
			spielerRepository.save(new Spieler(nummer, name, twitch));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateTeamBySpieler(String spieler, String team){
		
		Spieler newSpieler = spielerRepository.findByName(spieler);
		spielerRepository.delete(newSpieler);
		newSpieler.addTeam(team);
		spielerRepository.save(newSpieler);
		
	}
	
	@Override
	public void newSpielerS(String nummer, String name, String twitch){
		
		System.out.println(nummer + "das ist die Ausgabe");
		System.out.println(name + "das ist die Ausgabe");
		System.out.println(twitch + "das ist die Ausgabe");
		
		int spielerNummer = Integer.parseInt(nummer);
		
		try {
			spielerRepository.save(new Spieler(spielerNummer, name, twitch));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//
//	@Override
//	public Team getTeam(Integer teamNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
