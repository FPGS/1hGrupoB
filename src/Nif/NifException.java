package Nif;

public class NifException extends Exception {
	public NifException() {
		super("La letra del NIF no coincide");
	}

	public NifException(String error) {
		super(error);
	}
}
