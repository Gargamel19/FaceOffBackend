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
		return spielerRepository.findByName(name);
	}

//	@Override
//	public void newSpieler(Integer bN) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Team getTeam(Integer teamNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
