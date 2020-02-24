package Nif;

public class Ejecutable {
	public static void main(String[] args) throws DniException, NifException {
		Nif persona1;
		persona1 = new Nif(18174279);
		try {
			int x=7/0;
		} catch (ArithmeticException exc) {
			System.out.println("Hemos dividido por 0, no valemos pa na");
		} catch (Exception exc) {
			System.out.println("Excepción general");
		}
		persona1.mostrar();
	}
}
