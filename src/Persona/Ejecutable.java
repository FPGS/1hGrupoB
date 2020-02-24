package Persona;

public class Ejecutable {
	public static void main(String[] args) {
		Persona p1, p2, p3;
		Futbolista f1;
		p1 = new Persona(17736899, "Eduardo Bayego", 59, 1.87);
		p2 = new Persona(18174279, "Gabriel Nicolao", 73, 1.78);
		/*
		 * System.out.println("Me llamo " + p1.nombre); System.out.println("Me llamo " +
		 * p2.nombre);
		 */
		p1.mostrar();
		p2.mostrar();
		// p2.nombre = "josé ";
		p2.setNombre("josé ");
		p2.setAltura(1.45);
		p2.setDni(14457788);
		p2.setPeso(87);
		System.out.println(p2.getNombre());

		f1 = new Futbolista(9999999, "Messi ", 60, 1.70, "Barcelona", 10, "delantero");
		f1.mostrar();
		f1.setEquipo("zaragoza");
		f1.mostrar();
	}
}
