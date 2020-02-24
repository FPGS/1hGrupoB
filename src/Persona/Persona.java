package Persona;

public class Persona {
	private int dni;
	private String nombre;
	private int peso;
	private double altura;

	public Persona(int d, String n, int p, double a) {
		dni = d;
		nombre = n;
		peso = p;
		altura = a;

	}

	/*
	 * public Persana(int d, String n, int p, double a) { dni = d; nombre = n; peso
	 * = p; altura = a;
	 * 
	 * }
	 */

	public void mostrar() {
		System.out.println("me llamo " + nombre + "con DNI " + dni + ". peso: " + peso + " y mido: " + altura);
	}

	public String getNombre() {

		return nombre;
	}

	public int getDni() {

		return dni;
	}

	public double getAltura() {

		return altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setNombre(String nuevo) {
		nombre = nuevo;

	}

	public void setPeso(int nuevo) {
		peso = nuevo;

	}

	public void setDni(int dni) {
		this.dni = dni;

	}

	public void setAltura(double nuevo) {
		altura = nuevo;

	}

}

