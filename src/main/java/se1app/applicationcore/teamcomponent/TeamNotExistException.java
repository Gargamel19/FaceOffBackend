package se1app.applicationcore.teamcomponent;

public class TeamNotExistException extends Exception
{
	private static final long serialVersionUID = 1L;

	public TeamNotExistException() {
		super("Konto existiert nicht");
	}

	public TeamNotExistException(TeamNummer teamNumberType) {
		super("Konto mit der Nummer ".concat(teamNumberType.toString()).concat(" existiert nicht"));
	}
}