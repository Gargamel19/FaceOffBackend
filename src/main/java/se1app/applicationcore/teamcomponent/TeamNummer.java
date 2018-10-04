package se1app.applicationcore.teamcomponent;

import se1app.applicationcore.spielercomponent.Nummer;

public class TeamNummer extends Nummer {

	private static final long serialVersionUID = 1L;

	public TeamNummer(int id) {
		super(id);
	}
	public TeamNummer(String id) {
		super(id);
	}
	public TeamNummer(Integer id) {
		super(id);
	}

	
	@Override
	public String toString() {
		
		return "[ TeamNummer: " + super.toString()+" ]";
	}
}
