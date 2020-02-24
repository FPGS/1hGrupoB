package Nif;

public class Nif {
	// Con el DNI ser capaces de calcular la letra del NIF
	int dni;
	char letra;
	static char tabla[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
			'H', 'L', 'C', 'K', 'E' };

	public Nif(int dni, char letra) throws DniException, NifException {
		if ((dni < 10000000) || (dni > 99999999)) {
			throw new DniException("Te has equivocado con el DNI");
		}
		this.dni = dni;
		this.letra = letra;

		if (letra != tabla[dni % 23]) {
			throw new NifException("Error. La letra no coincide");

		}

	}

	public Nif(int dni) throws DniException {
		if ((dni > 10000000) && (dni < 99999999)) {
			this.dni = dni;
			this.letra = tabla[dni % 23];
		} else {
			throw new DniException();
		}

	}

	public void mostrar() {
		System.out.println(this.dni + " - " + this.letra);
	}


}
