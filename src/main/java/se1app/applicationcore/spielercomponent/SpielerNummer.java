package se1app.applicationcore.spielercomponent;

public class SpielerNummer extends Nummer {

	private static final long serialVersionUID = 1L;

	public SpielerNummer(int id) {
		super(id);
	}
	public SpielerNummer(String id) {
		super(id);
	}
	public SpielerNummer(Integer id) {
		super(id);
	}

	
	@Override
	public String toString() {
		
		return "[ SpielerNummer: " + super.toString()+" ]";
	}
}
