package Nif;

public class DniException extends Exception {
	public DniException() {
		super("Dni err�neo");
	}

	public DniException(String error) {
		super(error);
	}
}
