package Nif;

public class DniException extends Exception {
	public DniException() {
		super("Dni erróneo");
	}

	public DniException(String error) {
		super(error);
	}
}
