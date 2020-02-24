package Ejercicio17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Palabra extends Rectangle {
	Color color;
	String palabra;
	public static final int ANCHURA = 55;
	public static final int ALTURA = 15;
	int velx;

	public Palabra(String palabra) {
		super(300, (int) (Math.random() * 200) + 50, ANCHURA, ALTURA);
		this.color = Color.yellow;
		this.palabra = palabra;
		this.velx = (int) (Math.random() * 5) + 2;

	}

	public void dibujar(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(this.x, this.y, width, height);
		g.setColor(Color.black);
		g.drawString(palabra, x, y + ALTURA);
	}

	public void actualizar() {
		this.x -= this.velx;
		if (x <= 0) {
			Jugando.fin = true;
		}
	}
}
