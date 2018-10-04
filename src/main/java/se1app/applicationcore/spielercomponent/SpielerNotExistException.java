package se1app.applicationcore.spielercomponent;

public class SpielerNotExistException extends Exception
{
	private static final long serialVersionUID = 1L;

	public SpielerNotExistException() {
		super("Konto existiert nicht");
	}

	public SpielerNotExistException(int branchID) {
		super("Konto mit der Nummer ".concat(Integer.toString(branchID)).concat(" existiert nicht"));
	}
}