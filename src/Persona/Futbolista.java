package Persona;

public class Futbolista extends Persona {
	private String nombreEquipo;
	private int dorsal;
	private String posicion;

	public Futbolista(int dni, String nombre, int peso, double altura, String nEquipo, int dorsal,
			String posicion) {

		super(dni, nombre, peso, altura);// super sirve para coger los atributos de Persona que es su superclase
		nombreEquipo = nEquipo;
		this.dorsal = dorsal;
		this.posicion = posicion;

	}

	public String getEquipo() {
		return nombreEquipo;
	}

	public void setEquipo(String nuevoEquipo) {
		this.nombreEquipo = nuevoEquipo;
	}

	public int getDorsar() {
		return dorsal;
	}

	public void setDorsal(int nuevoDorsal) {
		this.dorsal = nuevoDorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}

	public void mostrar() {
		System.out.println(
				"Soy, futbolista, me llamo " + getNombre() + "soy del " + nombreEquipo);

	}

}
