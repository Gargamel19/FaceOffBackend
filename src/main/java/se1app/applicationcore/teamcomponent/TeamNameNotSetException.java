package se1app.applicationcore.teamcomponent;

public class TeamNameNotSetException extends Exception
{
	private static final long serialVersionUID = 1L;

	public TeamNameNotSetException() {
		super("Ihr Konto ist nicht gedeckt");
	}
	
	public TeamNameNotSetException(TeamNummer teamNumber) {
		super("Konto mit der Nummer ".concat(teamNumber.toString()).concat(" ist nicht gedeckt"));
	}
}