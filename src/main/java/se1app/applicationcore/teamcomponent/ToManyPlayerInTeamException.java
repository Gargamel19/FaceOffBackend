package se1app.applicationcore.teamcomponent;

public class ToManyPlayerInTeamException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ToManyPlayerInTeamException() {
		super("Es sind zu viele Spieler in diesem Team (max. 2)");
	}
}
